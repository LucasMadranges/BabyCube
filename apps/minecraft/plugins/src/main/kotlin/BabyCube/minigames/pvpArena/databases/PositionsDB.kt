package BabyCube.databases.home

import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.sql.Connection
import java.sql.DriverManager

object PositionsDB {
    lateinit var connection: Connection

    var tablePositions: String = "positions"

    fun onStart(plugin: JavaPlugin) {
        val dbFile = File(plugin.dataFolder, "PvpArena.db")
        plugin.logger.info("Chemin attendu pour la base SQLite : ${dbFile.absolutePath}")

        plugin.dataFolder.mkdirs()
        connection = DriverManager.getConnection("jdbc:sqlite:${dbFile.absolutePath}")

        val sql = """
            CREATE TABLE IF NOT EXISTS $tablePositions (
                uuid TEXT NOT NULL,
                name TEXT NOT NULL,
                x REAL,
                y REAL,
                z REAL,
                PRIMARY KEY(uuid, name)
            )
        """.trimIndent()
        connection.createStatement().use { it.execute(sql) }
        plugin.logger.info("Connexion SQLite prête !")
    }

    fun getAllTP(): List<Map<String, Any>>? {
        val sql = "SELECT * FROM $tablePositions"
        val positions = mutableListOf<Map<String, Any>>()
        connection.prepareStatement(sql).use { statement ->
            statement.executeQuery().use { resultSet ->
                while (resultSet.next()) {
                    positions.add(
                        mapOf(
                            "name" to resultSet.getString("name"),
                            "x" to resultSet.getDouble("x"),
                            "y" to resultSet.getDouble("y"),
                            "z" to resultSet.getDouble("z")
                        )
                    )
                }
            }
        }

        if (positions.isEmpty()) return null

        return positions
    }

    fun insertTP(
        uuid: String,
        name: String,
        x: Double,
        y: Double,
        z: Double,
    ) {
        val sql = """
        INSERT OR REPLACE INTO $tablePositions (uuid, name, x, y, z)
        VALUES (?, ?, ?, ?, ?)
    """.trimIndent()
        connection.prepareStatement(sql).use { statement ->
            statement.setString(1, uuid)
            statement.setString(2, name)
            statement.setDouble(3, x)
            statement.setDouble(4, y)
            statement.setDouble(5, z)
            statement.executeUpdate()
        }
    }
}
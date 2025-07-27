package BabyCube.databases.home

import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.sql.Connection
import java.sql.DriverManager

class HomeDB(private val plugin: JavaPlugin) {
    lateinit var connection: Connection

    fun onStart() {
        val dbFile = File(plugin.dataFolder, "homes.db")
        plugin.logger.info("Chemin attendu pour la base SQLite : ${dbFile.absolutePath}")

        plugin.dataFolder.mkdirs()
        connection = DriverManager.getConnection("jdbc:sqlite:${dbFile.absolutePath}")

        val sql = """
            CREATE TABLE IF NOT EXISTS homes (
                uuid TEXT NOT NULL,
                name TEXT NOT NULL,
                world TEXT,
                x REAL,
                y REAL,
                z REAL,
                yaw REAL,
                pitch REAL,
                PRIMARY KEY(uuid, name)
            )
        """.trimIndent()
        connection.createStatement().use { it.execute(sql) }
        plugin.logger.info("Connexion SQLite prête !")
    }

    fun getHome(uuid: String, name: String): Map<String, Any>? {
        val sql = "SELECT * FROM homes WHERE uuid = ? AND name = ?"
        connection.prepareStatement(sql).use { statement ->
            statement.setString(1, uuid)
            statement.setString(2, name)
            statement.executeQuery().use { resultSet ->
                if (resultSet.next()) {
                    return mapOf(
                        "uuid" to resultSet.getString("uuid"),
                        "name" to resultSet.getString("name"),
                        "world" to resultSet.getString("world"),
                        "x" to resultSet.getDouble("x"),
                        "y" to resultSet.getDouble("y"),
                        "z" to resultSet.getDouble("z"),
                        "yaw" to resultSet.getFloat("yaw"),
                        "pitch" to resultSet.getFloat("pitch")
                    )
                }
            }
        }
        return null
    }

    fun insertHome(
        uuid: String,
        name: String,
        world: String,
        x: Double,
        y: Double,
        z: Double,
        yaw: Float,
        pitch: Float
    ) {
        val sql = """
        INSERT OR REPLACE INTO homes (uuid, name, world, x, y, z, yaw, pitch)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    """.trimIndent()
        connection.prepareStatement(sql).use { statement ->
            statement.setString(1, uuid)
            statement.setString(2, name)
            statement.setString(3, world)
            statement.setDouble(4, x)
            statement.setDouble(5, y)
            statement.setDouble(6, z)
            statement.setFloat(7, yaw)
            statement.setFloat(8, pitch)
            statement.executeUpdate()
        }
    }
}
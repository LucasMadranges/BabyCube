package DevMinecraft.homeTeleport.Args

import DevMinecraft.homeTeleport.dbHelper
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player

class Home(private val player: Player, private val db: dbHelper) {
    fun getHome(name: String): Location? {
        val homeData = db.getHome(
            uuid = player.uniqueId.toString(),
            name = name
        ) ?: run {
            player.sendMessage("§c« $name » n'existe pas.")
            return null
        }

        println(Bukkit.getWorlds())

        val world = Bukkit.getWorld(homeData["world"] as String)
        val x = (homeData["x"] as Double)
        val y = (homeData["y"] as Double)
        val z = (homeData["z"] as Double)
        val yaw = (homeData["yaw"] as Float)
        val pitch = (homeData["pitch"] as Float)

        if (world != null) {
            val loc = Location(world, x, y, z, yaw, pitch)
            player.teleport(loc)
            player.sendMessage("§aTéléporté à ${homeData["name"]} avec succés !")
        } else {
            player.sendMessage("§cUn problème est survenu.")
        }
        return null
    }
}
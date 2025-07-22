package DevMinecraft.homeTeleport.Args

import DevMinecraft.homeTeleport.dbHelper
import org.bukkit.entity.Player

class Sethome(private val player: Player, private val db: dbHelper) {
    fun setHome(name: String) {
        db.insertHome(
            uuid = player.uniqueId.toString(),
            name = name,
            world = player.world.name,
            x = player.location.x,
            y = player.location.y,
            z = player.location.z,
            yaw = player.location.yaw,
            pitch = player.location.pitch,
        )

        player.sendMessage("§aHome « $name » enregistré avec succès !")
    }
}
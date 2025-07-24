package DevMinecraft.world.Args

import org.bukkit.Bukkit
import org.bukkit.entity.Player

class Tp {
    fun teleportToWorld(player: Player, worldName: String) {
        val world = Bukkit.getWorld(worldName)

        if (world == null) {
            player.sendMessage("§cLe monde $worldName n'existe pas.")
            return
        }

        world.let {
            player.teleport(it.spawnLocation)
            player.sendMessage("§aTéléportation à $worldName avec succés !")
        }
    }
}
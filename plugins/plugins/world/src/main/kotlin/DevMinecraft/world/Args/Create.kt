package DevMinecraft.world.Args

import org.bukkit.Bukkit
import org.bukkit.WorldCreator
import org.bukkit.entity.Player

class Create {
    fun createWorld(player: Player, worldName: String) {
        Bukkit.createWorld(WorldCreator(worldName))
        player.sendMessage("§aLe monde $worldName a été créé avec succés !")
    }
}
package DevMinecraft.antiJump

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class AntiJumpEvent(private val plugin: AntiJump) : Listener {
    @EventHandler
    fun onPlayerJump(event: PlayerJumpEvent) {
        if (plugin.isAntiJumpEnabled) {
            event.isCancelled = true
            event.player.sendMessage("§cLe jump est désactivé !")
        } else {
            return
        }
    }
}
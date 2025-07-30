package BabyCube.listeners

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class AntiJumpEvent(private val isAntiJumpEnabled: Boolean) : Listener {
    @EventHandler
    fun onPlayerJump(event: PlayerJumpEvent) {
        if (isAntiJumpEnabled) {
            event.isCancelled = true
            event.player.sendMessage("§cLe jump est désactivé !")
        } else {
            return
        }
    }
}
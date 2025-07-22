package DevMinecraft.welcomeMessage

import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class WelcomeMessage : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        player.sendMessage(Component.text("Hello, ${player.name}, Welcome to see you!"))
    }
}


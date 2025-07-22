package DevMinecraft.playerList

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Server
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import kotlin.math.roundToInt

class PlayerListItems : Listener {
    init {
        println("PlayerList has been enabled!")
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val server: Server = event.player.server
        val serverName = "DevMinecraft"

        event.player.sendPlayerListHeaderAndFooter(
            Component.text("Bienvenue sur le serveur ", NamedTextColor.GREEN)
                .append(Component.text(serverName, NamedTextColor.RED))
                .append(Component.text(" !", NamedTextColor.GREEN))
                .append(Component.text(" \n"))
                .append(Component.text(server.ip, NamedTextColor.RED))
                .append(Component.text(" \n", NamedTextColor.DARK_GRAY))
                .append(
                    Component.text("${"–".repeat(20)}[", NamedTextColor.DARK_GRAY)
                        .append(Component.text(server.onlinePlayers.size, NamedTextColor.RED))
                        .append(Component.text("/", NamedTextColor.DARK_GRAY))
                        .append(Component.text(server.maxPlayers, NamedTextColor.RED))
                        .append(Component.text("]${"–".repeat(20)}\n", NamedTextColor.DARK_GRAY))
                )
                .append(Component.text(" \n")),
            Component.text(" \n")
                .append(Component.text("${"–".repeat(46)}\n", NamedTextColor.DARK_GRAY))
                .append(Component.text(" \n"))
                .append(
                    Component.text("TPS: ", NamedTextColor.GRAY)
                        .append(Component.text("${server.tps[0].roundToInt()}", NamedTextColor.AQUA))
                        .append(Component.text(" | ", NamedTextColor.DARK_GRAY))
                        .append(Component.text("Ping: ", NamedTextColor.GRAY))
                        .append(Component.text("${event.player.ping}", NamedTextColor.GREEN))
                )
        )
    }
}
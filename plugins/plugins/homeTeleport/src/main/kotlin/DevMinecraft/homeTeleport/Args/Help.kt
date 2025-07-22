package DevMinecraft.homeTeleport.Args

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player

class Help(private val player: Player) {
    val maxLength = 50
    fun sendHelp() {
        player.sendMessage(
            Component.text("${"=".repeat(maxLength)}\n", NamedTextColor.DARK_GRAY)
                .append(
                    Component.text("/home home: ", NamedTextColor.RED)
                        .append(Component.text("Téléporte le joueur à la home.\n", NamedTextColor.GRAY))
                )
                .append(
                    Component.text("/home sethome: ", NamedTextColor.RED)
                        .append(Component.text("Défini la position du joueur sur 'home'.\n", NamedTextColor.GRAY))
                )
                .append(
                    Component.text("/home help: ", NamedTextColor.RED)
                        .append(Component.text("Affiche les différentes commandes possibles.\n", NamedTextColor.GRAY))
                )
                .append(
                    Component.text("=".repeat(maxLength), NamedTextColor.DARK_GRAY)
                )
        )
    }
}
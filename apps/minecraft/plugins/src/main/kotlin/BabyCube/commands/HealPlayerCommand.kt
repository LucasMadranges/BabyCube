package BabyCube.commands

import org.bukkit.attribute.Attribute
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealPlayerCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            val attribute = sender.getAttribute(Attribute.MAX_HEALTH)
            val maxHealth = attribute?.value ?: 20.0
            sender.health = maxHealth
            sender.foodLevel = 20
            sender.sendMessage("§aVous avez été soigné !")
            return true
        } else {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un opérateur.")
            return true
        }
    }
}
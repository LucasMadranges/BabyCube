package BabyCube.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class InvisibleCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            if (sender.isInvulnerable) {
                sender.isInvulnerable = false
                sender.isInvisible = false
                sender.allowFlight = false
                sender.sendMessage("§a${sender.name} n'est plus invisible.")
            } else {
                sender.isInvulnerable = true
                sender.isInvisible = true
                sender.allowFlight = true
                sender.sendMessage("§a${sender.name} est maintenant invisible.")
            }
        } else {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un opérateur.")
        }
        return true
    }
}
package DevMinecraft.doubleJump

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DoubleJumpCommand(private var isDoubleJumpEnabled: Boolean) : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            if (isDoubleJumpEnabled) {
                isDoubleJumpEnabled = false
                sender.sendMessage("§aLe double jump est maintenant désactivé.")
            } else {
                isDoubleJumpEnabled = true
                sender.sendMessage("§aLe double jump est maintenant activé.")
            }
            return true
        } else {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un opérateur.")
            return true
        }
    }
}
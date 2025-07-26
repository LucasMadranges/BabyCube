package BabyCube.doubleJump

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class DoubleJumpCommand(
    private val item: ItemStack
) : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            sender.inventory.addItem(item)
            sender.sendMessage("§aTu as reçu les bottes de Double Jump !")
            return true
        } else {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un opérateur.")
            return true
        }
    }
}
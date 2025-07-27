package BabyCube.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.random.Random

class RandomTeleportCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            val x = Random.nextDouble(-10000.0, 10000.0)
            val z = Random.nextDouble(-10000.0, 10000.0)
            sender.teleport(sender.location.set(x, 100.0, z))
            sender.sendMessage(
                "§aVous avez été téléporté en x = ${
                    String.format("%.3f", x).replace(",", ".")
                } et z = ${
                    String.format("%.3f", z).replace(",", ".")
                } !"
            )
        } else {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un opérateur.")
        }
        return true
    }
}
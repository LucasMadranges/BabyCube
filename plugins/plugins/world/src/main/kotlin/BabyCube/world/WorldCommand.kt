package DevMinecraft.createWorld

import BabyCube.world.Args.Create
import BabyCube.world.Args.Delete
import BabyCube.world.Args.Tp
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class WorldCommand : CommandExecutor, TabCompleter {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            when (args[0].lowercase()) {
                "create" -> {
                    if (args.size <= 1) {
                        sender.sendMessage("§cLe world doit avoir un nom.")
                        return true
                    }
                    val worldName = args[1]
                    Create().createWorld(sender, worldName)
                }

                "delete" -> {
                    if (args.size <= 1) {
                        sender.sendMessage("§cLe world doit avoir un nom.")
                        return true
                    }
                    val worldName = args[1]
                    Delete().deleteWorld(sender, worldName)
                }

                "tp" -> {
                    if (args.size <= 1) {
                        sender.sendMessage("§cLe world doit avoir un nom.")
                        return true
                    }
                    val worldName = args[1]
                    Tp().teleportToWorld(sender, worldName)
                }
            }
        } else {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un opérateur.")
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        if (args.size == 1) {
            return listOf("create", "delete", "tp", "help")
        }
        return emptyList()
    }
}
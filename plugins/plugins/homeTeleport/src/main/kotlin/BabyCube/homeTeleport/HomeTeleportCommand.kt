package BabyCube.homeTeleport

import BabyCube.homeTeleport.Args.Help
import BabyCube.homeTeleport.Args.Home
import BabyCube.homeTeleport.Args.Sethome
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class HomeTeleportCommand(private val db: dbHelper) : CommandExecutor, TabCompleter {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            when (args[0].lowercase()) {
                "help" -> {
                    Help(sender).sendHelp()
                }

                "sethome" -> {
                    if (args.size <= 1) {
                        sender.sendMessage("§cLe sethome doit avoir un nom.")
                        return true
                    }
                    val homeName = args[1]
                    Sethome(sender, db).setHome(homeName)
                }

                "home" -> {
                    if (args.size <= 1) {
                        sender.sendMessage("§cLe home doit avoir un nom.")
                        return true
                    }
                    val homeName = args[1]
                    Home(sender, db).getHome(homeName)
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
            return listOf("home", "sethome", "help")
        }
        return emptyList()
    }
}
package BabyCube.minigames.pvpArena.commands

import BabyCube.databases.home.PositionsDB
import BabyCube.homeTeleport.Args.SetPosition
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class PositionsCommand(private val db: PositionsDB) : CommandExecutor, TabCompleter {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            when (args[0].lowercase()) {
                "set" -> {
                    if (args.size <= 1) {
                        sender.sendMessage("§cLa position doit avoir un nom.")
                        return true
                    }
                    val tpName = args[1]
                    SetPosition.setPosition(tpName, sender, db)
                }

                "get" -> {
                    GetAllPositions.getAllPositions(sender, db)
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
            return listOf("delete", "set", "get")
        }
        return emptyList()
    }
}
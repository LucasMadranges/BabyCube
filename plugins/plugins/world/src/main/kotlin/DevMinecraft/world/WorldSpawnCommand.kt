package DevMinecraft.world

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class WorldSpawnCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player) {
            sender.teleport(Bukkit.getWorld("world")!!.spawnLocation)
            sender.sendMessage("§aTéléportion vers spawn...")
        }
        return true
    }
}
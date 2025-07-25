package BabyCube.catRain

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import kotlin.random.Random

class catRainCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player && sender.isOp) {
            val location = sender.location
            val world = location.world

            sender.sendRichMessage("<rainbow>Pluie de chaaaaaaaaaaaats !")
            repeat(100) {
                world.spawnEntity(
                    location.set(
                        Random.Default.nextDouble(sender.location.x - 5, sender.location.x + 5),
                        Random.Default.nextDouble(sender.location.y + 5, sender.location.y + 10),
                        Random.Default.nextDouble(sender.location.z - 5, sender.location.z + 5),
                    ),
                    EntityType.CAT
                )
            }
            return true
        } else {
            sender.sendMessage("Cette commande ne peut être utilisée que par un opérateur.")
            return true
        }
    }
}
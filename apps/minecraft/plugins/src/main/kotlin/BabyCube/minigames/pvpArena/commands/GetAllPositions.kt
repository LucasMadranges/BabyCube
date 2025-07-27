package BabyCube.minigames.pvpArena.commands

import BabyCube.databases.home.PositionsDB
import org.bukkit.entity.Player

object GetAllPositions {
    fun getAllPositions(player: Player, db: PositionsDB): List<Map<String, Any>>? {
        val positions = db.getAllTP()

        if (positions == null) {
            player.sendMessage("§cUne erreur est survenue lors de la récupération des positions.")
            return null
        }

        return positions
    }
}
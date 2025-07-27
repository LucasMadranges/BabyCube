package BabyCube.homeTeleport.Args

import BabyCube.databases.home.PositionsDB
import org.bukkit.entity.Player
import java.util.*

object SetPosition {
    fun setPosition(name: String, player: Player, db: PositionsDB) {
        db.insertTP(
            uuid = UUID.randomUUID().toString(),
            name = name,
            x = player.location.x,
            y = player.location.y,
            z = player.location.z,
        )

        player.sendMessage("§aHome « $name » enregistré avec succès !")
    }
}
package DevMinecraft.world.Args

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.io.File

class Delete {
    fun deleteWorld(player: Player, worldName: String) {
        Bukkit.unloadWorld(worldName, false)
        val supprime = supprimerDossier(File(Bukkit.getWorldContainer(), worldName))

        if (supprime) {
            player.sendMessage("§aLe world $worldName a été supprimé avec succés !")
        }
    }

    fun supprimerDossier(fichier: File): Boolean {
        if (fichier.isDirectory) {
            val enfants = fichier.listFiles() ?: return false
            for (enfant in enfants) {
                supprimerDossier(enfant)
            }
        }
        return fichier.delete()
    }
}
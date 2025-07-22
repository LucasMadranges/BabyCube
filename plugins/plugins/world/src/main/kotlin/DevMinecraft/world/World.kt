package DevMinecraft.world

import DevMinecraft.createWorld.WorldCommand
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class World : JavaPlugin() {

    override fun onEnable() {
        loadWorlds()
        getCommand("world")?.setExecutor(WorldCommand())
    }

    fun loadWorlds() {
        val dossierMonde = server.worldContainer
        dossierMonde.listFiles()?.filter { it.isDirectory }?.forEach { dossier ->
            if (File(dossier, "level.dat").exists() && server.getWorld(dossier.name) == null) {
                server.createWorld(org.bukkit.WorldCreator(dossier.name))
            }
        }
    }
}

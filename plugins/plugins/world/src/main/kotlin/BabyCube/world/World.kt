package BabyCube.world

import DevMinecraft.createWorld.WorldCommand
import org.bukkit.WorldCreator
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class World : JavaPlugin() {

    override fun onEnable() {
        loadWorlds()
        WorldItems().enableNavigationCompass(this)
        server.pluginManager.registerEvents(WorldEvent(this), this)
        getCommand("world")?.setExecutor(WorldCommand())
        getCommand("spawn")?.setExecutor(WorldSpawnCommand())
    }

    fun loadWorlds() {
        val dossierMonde = server.worldContainer
        dossierMonde.listFiles()?.filter { it.isDirectory }?.forEach { dossier ->
            if (File(dossier, "level.dat").exists() && server.getWorld(dossier.name) == null) {
                server.createWorld(WorldCreator(dossier.name))
            }
        }
    }
}
package BabyCube

import BabyCube.commands.AntiJumpCommand
import BabyCube.commands.CatRainCommand
import BabyCube.commands.DoubleJumpCommand
import BabyCube.commands.HealPlayerCommand
import BabyCube.commands.InvisibleCommand
import BabyCube.commands.RandomTeleportCommand
import BabyCube.commands.home.HomeTeleportCommand
import BabyCube.commands.world.WorldCommand
import BabyCube.commands.world.WorldSpawnCommand
import BabyCube.components.PlayerTabsUI
import BabyCube.components.SideBarUI
import BabyCube.databases.home.HomeDB
import BabyCube.items.DoubleJumpItems
import BabyCube.items.WorldItems
import BabyCube.listeners.AntiJumpEvent
import BabyCube.listeners.DoubleJumpEvent
import BabyCube.listeners.WelcomeEvent
import BabyCube.listeners.WorldEvent
import org.bukkit.WorldCreator
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class MainPlugin : JavaPlugin() {
    var isAntiJumpEnabled: Boolean = false
    val doubleJumpBoots = DoubleJumpItems().enableDoubleJumpBoots(this)
    var db: HomeDB = HomeDB(this)

    override fun onEnable() {
        loadWorlds()


        // NOTE : Commands
        getCommand("antijump")?.setExecutor(AntiJumpCommand(isAntiJumpEnabled))
        getCommand("catrain")?.setExecutor(CatRainCommand())
        getCommand("doublejump")?.setExecutor(DoubleJumpCommand(doubleJumpBoots))
        getCommand("heal")?.setExecutor(HealPlayerCommand())
        getCommand("invisible")?.setExecutor(InvisibleCommand())
        getCommand("rtp")?.setExecutor(RandomTeleportCommand())

        getCommand("home")?.setExecutor(HomeTeleportCommand(db))
        getCommand("home")?.tabCompleter = HomeTeleportCommand(db)

        getCommand("world")?.setExecutor(WorldCommand())
        getCommand("spawn")?.setExecutor(WorldSpawnCommand())

        // NOTE : Listeners
        server.pluginManager.registerEvents(WelcomeEvent(), this)
        server.pluginManager.registerEvents(AntiJumpEvent(isAntiJumpEnabled), this)
        server.pluginManager.registerEvents(DoubleJumpEvent(this), this)
        server.pluginManager.registerEvents(WorldEvent(this), this)

        // NOTE : Components
        server.pluginManager.registerEvents(PlayerTabsUI(), this)
        server.pluginManager.registerEvents(SideBarUI(this), this)


        // NOTE : Items
        DoubleJumpItems().enableDoubleJumpBoots(this)
        WorldItems().enableNavigationCompass(this)

        // NOTE : Databases
        db.onStart()
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
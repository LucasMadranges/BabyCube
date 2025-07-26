package BabyCube.homeTeleport

import org.bukkit.plugin.java.JavaPlugin

class HomeTeleport : JavaPlugin() {
    lateinit var db: dbHelper

    override fun onEnable() {
        db = dbHelper(this)
        db.onStart()

        val homeCommand = HomeTeleportCommand(db)
        getCommand("home")?.setExecutor(homeCommand)
        getCommand("home")?.tabCompleter = homeCommand
    }
}

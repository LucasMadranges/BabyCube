package BabyCube.randomTeleport

import org.bukkit.plugin.java.JavaPlugin

class randomTeleport : JavaPlugin() {
    override fun onEnable() {
        getCommand("rtp")?.setExecutor(randomTeleportCommand())
    }
}

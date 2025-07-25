package BabyCube.antiJump

import org.bukkit.plugin.java.JavaPlugin

class AntiJump : JavaPlugin() {
    var isAntiJumpEnabled: Boolean = false
    private lateinit var antiJumpEvent: AntiJumpEvent

    override fun onEnable() {
        antiJumpEvent = AntiJumpEvent(this)
        server.pluginManager.registerEvents(antiJumpEvent, this)

        getCommand("antijump")?.setExecutor(AntiJumpCommand(this))
    }
}

package DevMinecraft.doubleJump

import org.bukkit.plugin.java.JavaPlugin

class DoubleJump : JavaPlugin() {
    var isDoubleJumpEnabled: Boolean = false

    override fun onEnable() {
        server.pluginManager.registerEvents(DoubleJumpEvent(isDoubleJumpEnabled), this)

        getCommand("doublejump")?.setExecutor(DoubleJumpCommand(isDoubleJumpEnabled))
    }
}

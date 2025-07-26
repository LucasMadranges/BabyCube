package BabyCube.doubleJump

import org.bukkit.plugin.java.JavaPlugin

class DoubleJump : JavaPlugin() {
    override fun onEnable() {
        val doubleJumpBoots = DoubleJumpItems().enableDoubleJumpBoots(this)

        server.pluginManager.registerEvents(DoubleJumpEvent(this), this)

        getCommand("doublejump")?.setExecutor(DoubleJumpCommand(doubleJumpBoots))
    }
}

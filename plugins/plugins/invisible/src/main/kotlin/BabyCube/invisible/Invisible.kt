package BabyCube.invisible

import org.bukkit.plugin.java.JavaPlugin

class Invisible : JavaPlugin() {

    override fun onEnable() {
        getCommand("invisible")?.setExecutor(InvisibleCommand())
    }
}

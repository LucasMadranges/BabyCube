package DevMinecraft.healPlayer

import org.bukkit.plugin.java.JavaPlugin

class healPlayer : JavaPlugin() {
    override fun onEnable() {
        getCommand("heal")?.setExecutor(healPlayerCommand())
    }
}

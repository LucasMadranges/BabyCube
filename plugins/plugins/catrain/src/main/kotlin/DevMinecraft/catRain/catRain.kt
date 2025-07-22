package DevMinecraft.catRain

import org.bukkit.plugin.java.JavaPlugin

class catRain : JavaPlugin() {
    override fun onEnable() {
        getCommand("catrain")?.setExecutor(catRainCommand())
    }
}

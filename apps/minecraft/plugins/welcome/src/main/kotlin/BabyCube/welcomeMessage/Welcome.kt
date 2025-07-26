package BabyCube.welcomeMessage

import org.bukkit.plugin.java.JavaPlugin

class Welcome : JavaPlugin() {
    private lateinit var randomMessage: RandomMessage

    override fun onEnable() {
        randomMessage = RandomMessage()

        server.pluginManager.registerEvents(randomMessage, this)
    }
}
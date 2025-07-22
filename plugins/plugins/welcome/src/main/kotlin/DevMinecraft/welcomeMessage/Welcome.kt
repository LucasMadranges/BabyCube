package DevMinecraft.welcomeMessage

import org.bukkit.plugin.java.JavaPlugin

class Welcome : JavaPlugin() {
    private lateinit var welcomeMessage: WelcomeMessage
    private lateinit var randomMessage: RandomMessage

    override fun onEnable() {
        //welcomeMessage = WelcomeMessage()
        randomMessage = RandomMessage()

        //server.pluginManager.registerEvents(welcomeMessage, this)
        server.pluginManager.registerEvents(randomMessage, this)
    }
}
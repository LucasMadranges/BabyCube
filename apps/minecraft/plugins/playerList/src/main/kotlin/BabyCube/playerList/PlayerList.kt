package BabyCube.playerList

import org.bukkit.plugin.java.JavaPlugin

class PlayerList : JavaPlugin() {
    private lateinit var playerListItems: PlayerListItems

    override fun onEnable() {
        playerListItems = PlayerListItems()
        server.pluginManager.registerEvents(playerListItems, this)
    }
}

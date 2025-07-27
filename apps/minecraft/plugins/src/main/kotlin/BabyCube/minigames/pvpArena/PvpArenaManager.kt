package BabyCube.minigames.pvpArena

import BabyCube.databases.home.PositionsDB
import BabyCube.minigames.pvpArena.commands.PositionsCommand
import BabyCube.minigames.pvpArena.listeners.ArenaListener
import BabyCube.utils.CreateCustomItem
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

object PvpArenaManager {
    fun init(plugin: JavaPlugin) {
        PositionsDB.onStart(plugin)
        Bukkit.getPluginManager().registerEvents(ArenaListener(plugin), plugin)

        plugin.getCommand("home")?.setExecutor(PositionsCommand(PositionsDB))
        plugin.getCommand("home")?.tabCompleter = PositionsCommand(PositionsDB)
    }

    fun joinArena(plugin: JavaPlugin, player: Player) {
        player.sendMessage("§aTéléportion vers pvp arena...")
        player.teleport(Bukkit.getWorld("world_pvp_arena")!!.spawnLocation)
        player.closeInventory()
        player.inventory.clear()

        val book = CreateCustomItem.createItem(plugin, Material.BOOK, "book_classes", "Choose your classes")
        player.inventory.setItem(0, book)

        val sword = CreateCustomItem.createItem(plugin, Material.IRON_SWORD, "join_arena", "Join the arena")
        player.inventory.setItem(8, sword)
    }
}
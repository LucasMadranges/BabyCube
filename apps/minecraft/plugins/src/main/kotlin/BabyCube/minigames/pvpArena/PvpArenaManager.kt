package BabyCube.minigames.pvpArena

import BabyCube.utils.createCustomItem
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

object PvpArenaManager {
    fun init(plugin: JavaPlugin) {
        Bukkit.getPluginManager().registerEvents(ArenaListener(), plugin)
    }

    fun joinArena(plugin: JavaPlugin, player: Player) {
        player.sendMessage("§aTéléportion vers pvp arena...")
        player.teleport(Bukkit.getWorld("world_pvp_arena")!!.spawnLocation)
        player.closeInventory()
        player.inventory.clear()

        val book = createCustomItem.createItem(plugin, Material.BOOK, "book_classes", "Choose your classes")
        player.inventory.setItem(0, book)

        val sword = createCustomItem.createItem(plugin, Material.IRON_SWORD, "join_arena", "Join the arena")
        player.inventory.setItem(8, sword)
    }
}
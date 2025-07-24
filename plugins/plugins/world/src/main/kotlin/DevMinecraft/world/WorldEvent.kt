package DevMinecraft.world

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class WorldEvent(private val plugin: JavaPlugin) : Listener {
    private val worldItems = WorldItems()

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val compass = worldItems.enableNavigationCompass(plugin)
        if (!player.inventory.contains(compass)) {
            player.inventory.setItem(4, compass)
        }
    }

    @EventHandler
    fun onPlayerDropItem(event: PlayerDropItemEvent) {
        val item = event.itemDrop.itemStack
        val meta = item.itemMeta ?: return

        val key = NamespacedKey(plugin, "navigation_compass")
        if (meta.persistentDataContainer.has(key, PersistentDataType.BYTE)) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val item = event.item ?: return
        val meta = item.itemMeta ?: return

        val key = NamespacedKey(plugin, "navigation_compass")
        if (item.type == Material.COMPASS &&
            meta.persistentDataContainer.has(key, PersistentDataType.BYTE)
        ) {
            event.isCancelled = true

            val inv: Inventory = Bukkit.createInventory(
                null,
                27,
                Component.text("Menu Navigation")
            )
            inv.setItem(13, ItemStack(Material.IRON_SWORD))

            event.player.openInventory(inv)
        }
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val currentItem = event.currentItem ?: return
        val meta = currentItem.itemMeta ?: return
        val player = event.whoClicked

        val key = NamespacedKey(plugin, "navigation_compass")
        if (meta.persistentDataContainer.has(key, PersistentDataType.BYTE)) {
            event.isCancelled = true
        }

        if (event.view.title() == Component.text("Menu Navigation")) {
            event.isCancelled = true

            val clicked = event.currentItem ?: return

            if (clicked.type == Material.IRON_SWORD) {
                player.sendMessage("§aTéléportion vers pvp arena...")
                player.teleport(Bukkit.getWorld("world")!!.spawnLocation)
                player.closeInventory()
            }
        }
    }
}
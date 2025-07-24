package DevMinecraft.world

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class WorldItems {
    fun enableNavigationCompass(plugin: JavaPlugin): ItemStack {
        val item = ItemStack(org.bukkit.Material.COMPASS)
        val meta = item.itemMeta

        meta.displayName(Component.text("Navigation", NamedTextColor.GOLD))

        val key = NamespacedKey(plugin, "navigation_compass")
        meta.persistentDataContainer.set(key, PersistentDataType.BYTE, 1)
        item.itemMeta = meta

        return item
    }
}
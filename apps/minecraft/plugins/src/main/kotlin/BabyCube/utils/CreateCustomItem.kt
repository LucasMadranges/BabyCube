package BabyCube.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

object CreateCustomItem {
    fun createItem(
        plugin: JavaPlugin,
        material: Material,
        name: String,
        title: String
    ): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta

        meta.displayName(Component.text(title, NamedTextColor.GOLD))

        val key = NamespacedKey(plugin, name)
        meta.persistentDataContainer.set(key, PersistentDataType.BYTE, 1)
        item.itemMeta = meta

        return item
    }
}
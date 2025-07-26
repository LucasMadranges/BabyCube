package BabyCube.doubleJump

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class DoubleJumpItems {
    fun enableDoubleJumpBoots(plugin: JavaPlugin): ItemStack {
        val item = ItemStack(Material.IRON_BOOTS)
        val meta = item.itemMeta

        meta.displayName(Component.text("Bottes de Double Jump", NamedTextColor.GOLD))

        val key = NamespacedKey(plugin, "double_jump_boots")
        meta.persistentDataContainer.set(key, PersistentDataType.BYTE, 1)
        item.itemMeta = meta

        return item
    }

    companion object {
        // Fonction utilitaire réutilisable
        fun hasDoubleJumpBoots(player: Player, plugin: JavaPlugin): Boolean {
            val boots = player.inventory.boots
            val key = NamespacedKey(plugin, "double_jump_boots")
            return boots != null
                    && boots.hasItemMeta()
                    && boots.itemMeta.persistentDataContainer.has(key, PersistentDataType.BYTE)
        }
    }
}
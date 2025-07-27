package BabyCube.minigames.pvpArena.listeners

import BabyCube.databases.home.PositionsDB
import BabyCube.minigames.pvpArena.commands.GetAllPositions
import BabyCube.utils.CreateCustomItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class ArenaListener(private val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val item = event.item ?: return
        val meta = item.itemMeta ?: return

        val key = NamespacedKey(plugin, "book_classes")
        if (item.type == Material.BOOK &&
            meta.persistentDataContainer.has(key, PersistentDataType.BYTE)
        ) {
            event.isCancelled = true

            val inv: Inventory = Bukkit.createInventory(
                null,
                27,
                Component.text("Choose your classes:")
            )
            inv.setItem(
                11,
                ItemStack(CreateCustomItem.createItem(plugin, Material.IRON_AXE, "knight_classes", "Knight Classes"))
            )
            inv.setItem(
                12,
                ItemStack(
                    CreateCustomItem.createItem(
                        plugin,
                        Material.IRON_SWORD,
                        "assassin_classes",
                        "Assassin Classes"
                    )
                )
            )
            inv.setItem(
                13,
                ItemStack(CreateCustomItem.createItem(plugin, Material.BOW, "archer_classes", "Archer Classes"))
            )
            inv.setItem(
                14,
                ItemStack(CreateCustomItem.createItem(plugin, Material.POTION, "mage_classes", "Mage Classes"))
            )
            inv.setItem(
                15,
                ItemStack(
                    CreateCustomItem.createItem(
                        plugin,
                        Material.FIRE_CHARGE,
                        "pyroman_classes",
                        "Pyroman Classes"
                    )
                )
            )

            event.player.openInventory(inv)
        }

        val swordKey = NamespacedKey(plugin, "join_arena")
        if (item.type == Material.IRON_SWORD &&
            meta.persistentDataContainer.has(swordKey, PersistentDataType.BYTE)
        ) {
            event.isCancelled = true
            val player = event.player
            val position = GetAllPositions.getAllPositions(player, PositionsDB)?.random()

            if (position == null) {
                player.sendMessage("§cAucune position disponible pour le moment.")
                return
            }

            val location: org.bukkit.Location = org.bukkit.Location(
                player.world,
                (position.get("x")) as Double,
                (position.get("y")) as Double,
                (position.get("z")) as Double
            )

            player.sendMessage(
                Component.text("§aTéléportation dans l'arène en cours...")
            )
            Bukkit.getScheduler().runTaskLater(
                plugin,
                Runnable {
                    player.teleport(location)
                    player.sendMessage("§aTéléportation réussie !")
                },
                60L
            )
        }
    }
}
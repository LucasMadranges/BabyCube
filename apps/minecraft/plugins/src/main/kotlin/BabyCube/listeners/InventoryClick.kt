package BabyCube.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InventoryClick : Listener {
    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        event.isCancelled = true
    }
}
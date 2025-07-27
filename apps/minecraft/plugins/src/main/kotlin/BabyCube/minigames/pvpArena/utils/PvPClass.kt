package BabyCube.minigames.pvpArena.utils

import org.bukkit.Material

enum class PvPClass(val displayName: String, val icon: Material) {
    KNIGHT("Guerrier", Material.IRON_SWORD),
    ASSASSIN("Assassin", Material.BOW),
    ARCHER("Archer", Material.BLAZE_ROD),
    MAGE("Mage", Material.SHIELD),
    PYROMANE("Pyromane", Material.FIRE_CHARGE)
}
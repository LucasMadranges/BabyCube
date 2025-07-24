package DevMinecraft.doubleJump

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerToggleFlightEvent
import org.bukkit.plugin.java.JavaPlugin

class DoubleJumpEvent(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val player = event.player

        if (player.gameMode == GameMode.CREATIVE) return

        val hasDoubleJumpBoots = DoubleJumpItems.hasDoubleJumpBoots(player, plugin)
        if (!hasDoubleJumpBoots) return
        
        val onGround = player.location.clone().subtract(0.0, 0.1, 0.0).block.type.isSolid

        if (onGround) {
            player.allowFlight = true
        }
    }

    @EventHandler
    fun onPlayerDoubleJump(event: PlayerToggleFlightEvent) {
        val player = event.player

        if (player.gameMode == GameMode.CREATIVE) return

        event.isCancelled = true
        player.allowFlight = false
        player.isFlying = false

        val hasDoubleJumpBoots = DoubleJumpItems.hasDoubleJumpBoots(player, plugin)
        if (!hasDoubleJumpBoots) return

        val boost = player.location.direction.multiply(1.1).setY(0.9)
        player.velocity = boost

        player.world.playSound(player.location, "entity.player.small_fall", 0.5f, 1.2f)

        val particleLocationArr = arrayOf(
            // Nord Sud Est Ouest
            player.location.clone().add(0.25, -0.1, -0.25),
            player.location.clone().add(0.25, -0.1, 0.25),
            player.location.clone().add(-0.25, -0.1, -0.25),
            player.location.clone().add(-0.25, -0.1, 0.25),
            // Corners
            player.location.clone().add(0.35, -0.1, 0.0),
            player.location.clone().add(-0.35, -0.1, 0.0),
            player.location.clone().add(0.0, -0.1, -0.35),
            player.location.clone().add(0.0, -0.1, 0.35),
        )

        for (particleLocation in particleLocationArr) {
            player.world.spawnParticle(
                org.bukkit.Particle.WHITE_SMOKE,
                particleLocation,
                10,
                0.0,
                0.0,
                0.0,
                0.01
            )
        }
    }
}
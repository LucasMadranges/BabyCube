package DevMinecraft.doubleJump

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerToggleFlightEvent

class DoubleJumpEvent(private val isDoubleJumpEnabled: Boolean) : Listener {
    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (isDoubleJumpEnabled) return

        val player = event.player

        if (player.gameMode == GameMode.CREATIVE) return

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

        val boost = player.location.direction.multiply(1.1).setY(0.9)
        player.velocity = boost

        player.world.playSound(player.location, "entity.player.small_fall", 0.5f, 1.2f)

        val particleLocationArr = arrayOf(
            // NOTE : Nord Sud Est Ouest
            player.location.clone().add(0.25, -0.1, -0.25),
            player.location.clone().add(0.25, -0.1, 0.25),
            player.location.clone().add(-0.25, -0.1, -0.25),
            player.location.clone().add(-0.25, -0.1, 0.25),
            // NOTE : Corner
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
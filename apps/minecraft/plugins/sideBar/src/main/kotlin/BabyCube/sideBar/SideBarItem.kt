package BabyCube.sideBar

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Statistic
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scoreboard.Criteria
import org.bukkit.scoreboard.DisplaySlot

class SideBarItem(private val plugin: JavaPlugin) : Listener {
    init {
        println("SideBarItem has been enabled!")
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        val objective = scoreboard.registerNewObjective(
            "info",
            Criteria.DUMMY,
            Component.text("Player info")
        )
        objective.displaySlot = DisplaySlot.SIDEBAR
        event.player.scoreboard = scoreboard

        object : BukkitRunnable() {
            override fun run() {
                if (!event.player.isOnline) {
                    cancel()
                    return
                }
                // Nettoie le scoreboard
                scoreboard.entries.forEach { scoreboard.resetScores(it) }

                val playTimeSec = player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20
                val timeToDisplay = "${playTimeSec / 3600}h ${(playTimeSec % 3600) / 60}min ${playTimeSec % 60}s"

                objective.getScore("§a–".repeat(20)).score = 9
                objective.getScore("Pseudo: §c${player.name}").score = 8
                objective.getScore("Health: §c${player.health}").score = 7
                objective.getScore(
                    "Jump: §c" + player.getStatistic(Statistic.JUMP)
                ).score = 6
                objective.getScore("Position:").score = 5
                objective.getScore("- x: §c${String.format("%.3f", player.location.x).replace(",", ".")}").score = 4
                objective.getScore("- y: §c${String.format("%.3f", player.location.y).replace(",", ".")}").score = 3
                objective.getScore("- z: §c${String.format("%.3f", player.location.z).replace(",", ".")}").score = 2
                objective.getScore("Game time: §c$timeToDisplay").score = 1
                objective.getScore(
                    "Ratio (K/D): §c" + player.getStatistic(Statistic.PLAYER_KILLS) + "/" + player.getStatistic(
                        Statistic.DEATHS
                    )
                ).score =
                    0
            }
        }.runTaskTimer(plugin, 0L, 20L)
    }
}
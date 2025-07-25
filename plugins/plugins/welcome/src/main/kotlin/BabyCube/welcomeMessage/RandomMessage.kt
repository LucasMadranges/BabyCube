package BabyCube.welcomeMessage

import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.meta.FireworkMeta


class RandomMessage : Listener {
    private var message: Array<String> = arrayOf(
        "« Tu as signé pour casser des blocs, pas des cœurs. »",
        "« Rappelle-toi : la lave, c’est pas une piscine. »",
        "« Un poulet t’observe… Il sait. »",
        "« Tu viens d’entrer. Ton inventaire ne survivra pas. »",
        "« Bienvenue, noble dompteur de cochons. »",
        "« Les moutons t’ont élu comme nouveau berger. »",
        "« Poisson pêché : joueur naïf. Bienvenue ! »",
        "« Essaie de ne pas tout faire exploser. Surtout toi. »",
        "« Ce n’est pas un hôtel ici. Trouve-toi un lit ! »",
        "« N’oublie pas : les creepers aiment les câlins. »",
        "« Astuce du jour : les fours ne sont pas des micro-ondes. »",
        "« Un squelette a parié 3 flèches que tu ne survivras pas à ta première nuit. »",
        "« Si tu entends \"Hhhsss\", cours. Pas de questions. »",
        "« Tu es chez toi ici. Enfin… jusqu’à ce que tu casses ma porte. »",
        "« Cat > Blocks > Chirp. On ne discute pas. »",
        "« Ta mission : survivre. Ton équipement : un bâton. Bonne chance. »",
        "« Aucun villageois n’a été maltraité… pour l’instant. »",
        "« Watermelon gang t’accueille à bras ouverts. »",
        "« Conseil : casser la glace ne fonctionne pas avec les zombies. »",
        "« Mode Hardcore émotionnel activé. Ne t’attache à rien. »",
    )
    private var color: Array<Color> = arrayOf(
        Color.AQUA,
        Color.BLUE,
        Color.FUCHSIA,
        Color.GREEN,
        Color.LIME,
        Color.MAROON,
        Color.NAVY,
        Color.OLIVE,
        Color.ORANGE,
        Color.PURPLE,
    )

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val maxLength = 50

        LaunchFirework(player)
        Bukkit.getScheduler().runTaskLater(
            Bukkit.getPluginManager().getPlugin("WelcomePlugin")!!,
            Runnable {
                player.sendMessage(
                    "§8${"=".repeat(maxLength)}\n" +
                            " \n" +
                            "§a${" ".repeat(maxLength / 2)}Bienvenue, §c${player.name} !\n" +
                            " \n" +
                            "§f${" ".repeat(maxLength / 6)}${message.random()}\n" +
                            " \n" +
                            "§8${"=".repeat(maxLength)}"
                )
            },
            2L // délai de 2 ticks (~0.1s)
        )
    }

    fun LaunchFirework(player: Player) {
        val world = player.world
        val location = player.location

        repeat(3) {
            val entity = world.spawnEntity(location, EntityType.FIREWORK_ROCKET)
            val firework = entity as? Firework ?: return
            val meta: FireworkMeta = firework.fireworkMeta
            meta.addEffect(
                FireworkEffect.builder()
                    .withColor(color.random())
                    .with(FireworkEffect.Type.BALL_LARGE)
                    .withFlicker()
                    .withTrail()
                    .build()
            )
            meta.power = 1
            firework.fireworkMeta = meta
        }
    }
}
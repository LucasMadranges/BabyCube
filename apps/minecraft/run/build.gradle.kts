plugins {
    id("xyz.jpenilla.run-paper")
}

val pluginsList = listOf(
    "catrain",
    "heal",
    "randomTeleport",
    "welcome",
    "invisible",
    "anti-jump",
    "playerList",
    "sideBar",
    "homeTeleport",
    "world",
    "doubleJump",
    "pvpArena"
)

tasks {
    val cleanExtraPlugins by registering(Delete::class) {
        delete(file("run/plugins/.paper-remapped/extra-plugins"))
    }

    val copyPlugins by registering(Copy::class) {
        dependsOn(cleanExtraPlugins)

        pluginsList.forEach { pluginName ->
            from(project(":apps:minecraft:plugins:$pluginName").tasks.named("shadowJar"))
        }

        into(layout.buildDirectory.dir("server/plugins"))
    }

    runServer {
        minecraftVersion("1.21.8")
        dependsOn(copyPlugins)
        pluginJars.from(fileTree(layout.buildDirectory.dir("server/plugins")))
    }
}
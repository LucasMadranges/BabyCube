plugins {
    id("xyz.jpenilla.run-paper")
}

tasks {
    val cleanExtraPlugins by registering(Delete::class) {
        delete(file("run/plugins/.paper-remapped/extra-plugins"))
    }

    val copyPlugins by registering(Copy::class) {
        dependsOn(cleanExtraPlugins)
        from(project(":plugins:catrain").tasks.named("shadowJar"))
        from(project(":plugins:heal").tasks.named("shadowJar"))
        from(project(":plugins:randomTeleport").tasks.named("shadowJar"))
        from(project(":plugins:welcome").tasks.named("shadowJar"))
        from(project(":plugins:invisible").tasks.named("shadowJar"))
        from(project(":plugins:anti-jump").tasks.named("shadowJar"))
        from(project(":plugins:playerList").tasks.named("shadowJar"))
        from(project(":plugins:sideBar").tasks.named("shadowJar"))
        from(project(":plugins:homeTeleport").tasks.named("shadowJar"))
        from(project(":plugins:world").tasks.named("shadowJar"))
        from(project(":plugins:doubleJump").tasks.named("shadowJar"))
        into(layout.buildDirectory.dir("server/plugins"))
    }

    runServer {
        minecraftVersion("1.21.8")
        dependsOn(copyPlugins)
        pluginJars.from(fileTree(layout.buildDirectory.dir("server/plugins")))
    }
}
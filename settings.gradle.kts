rootProject.name = "BabyCube"

include("apps:minecraft")
include(
    "apps:minecraft:plugins:welcome",
    "apps:minecraft:plugins:heal",
    "apps:minecraft:plugins:randomTeleport",
    "apps:minecraft:plugins:catrain",
    "apps:minecraft:plugins:invisible",
    "apps:minecraft:plugins:anti-jump",
    "apps:minecraft:plugins:playerList",
    "apps:minecraft:plugins:sideBar",
    "apps:minecraft:plugins:homeTeleport",
    "apps:minecraft:plugins:world",
    "apps:minecraft:plugins:doubleJump",
    "apps:minecraft:plugins:pvpArena",
    "apps:minecraft:run"
)

project(":apps:minecraft").projectDir = file("apps/minecraft")

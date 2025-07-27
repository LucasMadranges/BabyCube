rootProject.name = "BabyCube"

include("apps:minecraft")
include(
    "apps:minecraft:plugins",
    "apps:minecraft:run"
)

project(":apps:minecraft").projectDir = file("apps/minecraft")

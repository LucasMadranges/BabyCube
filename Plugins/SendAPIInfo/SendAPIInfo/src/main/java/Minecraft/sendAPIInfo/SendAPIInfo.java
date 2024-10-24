package Minecraft.sendAPIInfo;

import org.bukkit.plugin.java.JavaPlugin;

public final class SendAPIInfo extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello World");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

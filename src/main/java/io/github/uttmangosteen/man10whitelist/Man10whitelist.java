package io.github.uttmangosteen.man10whitelist;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.io.BukkitObjectInputStream;

public final class Man10whitelist extends JavaPlugin {
    JavaPlugin Mwait;
    @Override
    public void onEnable() {
        this.Mwait = this;
        saveDefaultConfig();
        int whitelist_delay = Mwait.getConfig().getInt("whitelist_delay");
        Bukkit.getScheduler().runTaskLater(this, new Runnable()
        {
            @Override
            public void run(){
                Bukkit.setWhitelist(false);
                System.out.println("Whitelist is now turned off");
            }
        }, whitelist_delay * 20);
    }


    @Override
    public void onDisable() {
        Bukkit.setWhitelist(true);
        System.out.println("Whitelist is now turned on");
    }
}

package dev.oxs.mutesign;

import dev.oxs.mutesign.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MuteSign extends JavaPlugin implements Listener {

    private boolean essentialsHook = false;

    private Logger log;
    private String pluginName;
    //Basic Plugin Info
    private static MuteSign plugin;
    private PluginDescriptionFile pdf;

    @Override
    public void onEnable() {


        plugin = this;
        log = this.getServer().getLogger();
        pdf = this.getDescription();
        pluginName = pdf.getName();

        final MuteSignListener c = new MuteSignListener(plugin);
        Bukkit.getPluginManager().registerEvents(c, plugin);

        // commmands
        Bukkit.getPluginCommand("mutesign").setExecutor(new MuteSignCommand(plugin));

        pluginName = pdf.getName();

        log.info("[" + pluginName + "] Is Loading, Version: " + pdf.getVersion());
    }

    @Override
    public void onDisable() {
        log.info(pluginName + " has been disabled.");
    }
    
}

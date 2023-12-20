package dev.oxs.mutesign.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class MuteSignCommand implements CommandExecutor {

    private final Plugin plugin;

    public MuteSignCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender.hasPermission("mutesign.mutesign") || commandSender.isOp())) {
            commandSender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        } else {
            commandSender.sendMessage("Version : " + ChatColor.BLUE + "v" + plugin.getDescription().getVersion());
            commandSender.sendMessage("Description : " + ChatColor.BLUE + plugin.getDescription().getDescription());
            commandSender.sendMessage("Author(s) : " + ChatColor.BLUE + plugin.getDescription().getAuthors().toString());
            return true;
        }
    }
}

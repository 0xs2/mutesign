package dev.oxs.mutesign;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import org.bukkit.plugin.Plugin;

public class MuteSignListener implements Listener {

    private MuteSign plugin;

    public MuteSignListener(MuteSign plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {


        if (event.getBlockPlaced().getType() == Material.SIGN || event.getBlockPlaced().getType() == Material.SIGN_POST || event.getBlockPlaced().getType() == Material.WALL_SIGN) {
            Player player = event.getPlayer();
            if(isPlayerMuted(player.getName())) {

                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not allowed to place signs when you are muted.");
            }
        }
    }

    public boolean isPlayerMuted(String player) {
        Plugin essentials = Bukkit.getPluginManager().getPlugin("Essentials");

        if (essentials instanceof Essentials) {
            Essentials essentialsPlugin = (Essentials) essentials;
            User user = essentialsPlugin.getUser(player);
            return user.isMuted();
        }

        return false;

    }
}

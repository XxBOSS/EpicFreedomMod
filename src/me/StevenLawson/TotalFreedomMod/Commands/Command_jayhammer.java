package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "For the bad Superadmins", usage = "/<command> <playername>")
public class Command_jayhammer extends TFM_Command
{

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.SYS_ADMINS.contains(sender.getName()) && !sender.getName().equals("tylerhyperHD") && !sender.getName().equals("cldoesmc"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not jay and may not use this mother fucking command.");
            }

            return true;
        }

        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for(Player player : Bukkit.getOnlinePlayers())
                {
                player.playSound(player.getLocation(), Sound.WOLF_HOWL, 5, 5);
                }
            }
        }.runTaskLater(plugin, 2L * 20L);

        TFM_Util.bcastMsg(ChatColor.DARK_RED + "jayscoob - I AM REALLY DISAPPOINTED IN YOU " + player.getName() + "!!!");
        TFM_Util.bcastMsg(ChatColor.DARK_PURPLE + "jayscoob - YOU SHALL FACE MY WRATH");
 
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
        player.getWorld().createExplosion(player.getLocation(), 4F); 
        player.getWorld().strikeLightning(player.getLocation()); 
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.setFireTicks(10000);
 

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }

        // remove from whitelist
        player.setWhitelisted(false);

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban uuid
        TFM_BanManager.addUuidBan(player);

        // set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // ignite player
        player.setFireTicks(10000);

        // generate explosion
        player.getWorld().createExplosion(player.getLocation(), 4F);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
                player.getWorld().createExplosion(player.getLocation(), 4F); 
                player.getWorld().strikeLightning(player.getLocation()); 
                player.getWorld().createExplosion(player.getLocation(), 4F);
                player.setFireTicks(10000);
                
                for(Player player : Bukkit.getOnlinePlayers())
                {
                player.playSound(player.getLocation(), Sound.WOLF_HOWL, 5, 5);
                }
            }
        }.runTaskLater(plugin, 1L * 20L);
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                TFM_Util.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.DARK_BLUE + "I told you not to mess with me! All well!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}
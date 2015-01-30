package me.StevenLawson.TotalFreedomMod.Commands;

/*

  ____                 _                              _     _             
 |  _ \    ___   ___  (_)   __ _   _ __     ___    __| |   | |__    _   _ 
 | | | |  / _ \ / __| | |  / _` | | '_ \   / _ \  / _` |   | '_ \  | | | |
 | |_| | |  __/ \__ \ | | | (_| | | | | | |  __/ | (_| |   | |_) | | |_| |
 |____/   \___| |___/ |_|  \__, | |_| |_|  \___|  \__,_|   |_.__/   \__, |
                           |___/                                    |___/ 


  _             _                 _                                     _   _   ____  
 | |_   _   _  | |   ___   _ __  | |__    _   _   _ __     ___   _ __  | | | | |  _ \ 
 | __| | | | | | |  / _ \ | '__| | '_ \  | | | | | '_ \   / _ \ | '__| | |_| | | | | |
 | |_  | |_| | | | |  __/ | |    | | | | | |_| | | |_) | |  __/ | |    |  _  | | |_| |
  \__|  \__, | |_|  \___| |_|    |_| |_|  \__, | | .__/   \___| |_|    |_| |_| |____/ 
        |___/                             |___/  |_|                                  



*/

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_PermbanList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "For the bad admins", usage = "/<command> <playername>")
public class Command_hell extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
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

        TFM_Util.adminAction(sender.getName(), "Making it rain hell over " + player.getName(), true);
        TFM_Util.bcastMsg(player.getName() + " will go to hell!", ChatColor.RED);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        TFM_Util.bcastMsg(player.getName() + " will go to hell!", ChatColor.RED);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        TFM_Util.bcastMsg(player.getName() + " will go to hell!", ChatColor.RED);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        TFM_Util.bcastMsg(player.getName() + " will go to hell!", ChatColor.RED);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        TFM_Util.bcastMsg(player.getName() + " will go to hell!", ChatColor.RED);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        TFM_Util.bcastMsg(player.getName() + " is going to mother fucking die!", ChatColor.RED);
        
        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Fucking " + player.getName() + " with " + sender.getName() + "'s dick", true);
            TFM_AdminList.removeSuperadmin(player);
        }

        // remove from whitelist
        player.setWhitelisted(false);
        
        // rolls the player back
        server.dispatchCommand(sender, "co rb u:" + player.getName() + " t:24h r:global");

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
                String ip = TFM_Util.getFuzzyIp(player.getAddress().getAddress().getHostAddress());
                TFM_Util.bcastMsg(String.format("%s - Hell to %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - Hell to %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - Hell to %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - Hell to %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - Hell to %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);


                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.RED + "YOU MOTHERFUCKING DON'T EVER MESS WITH THE TYLER OR YOU GET FUCKING BANNED M8!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}

package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidResolver;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "For the bad Superadmins", usage = "/<command> <playername>")
public class Command_stampy extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
    
           if (!sender.getName().equalsIgnoreCase("Stampy100"))
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
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
        TFM_Util.adminAction(sender.getName(), "Stampy100 is mad with " + player.getName(), true);
        TFM_Util.bcastMsg(sender.getName() + " will COMPLETLY demolish " + player.getName() + " and will be sent to hell!", ChatColor.GREEN);
        TFM_Util.bcastMsg(sender.getName() + "  Never Fuck with Stampy " + player.getName() + "What did I tell you? You fucking dumb ass fool", ChatColor.BLUE);
        TFM_Util.bcastMsg(sender.getName() + " is RAISING HELLO OVER " + player.getName() + "!!!!", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + " is being Stmapy'd by " + sender.getName() + " Because he is a stupid!", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + ", hey you know what Stampy100 is saying right now for you?? HE SAYS YOU ARE A LITTLE BITCH! ASSHOLE! THAT HAS NO RESPECT FOR HIM!", ChatColor.DARK_RED);
        TFM_Util.bcastMsg(player.getName() + " is a bitch! ", ChatColor.GOLD);
        TFM_Util.bcastMsg(player.getName() + " is a dickface! ", ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + " and needs to get a life! ", ChatColor.BLUE);
        TFM_Util.bcastMsg(player.getName() + " is being permbanned by stampy! ", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + " go back to sitting on your TV watching TV porn... ", ChatColor.DARK_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " and... FUCK OFF AND NEVER DISRESPECT STAMPY EVER AGAIN!! ", ChatColor.LIGHT_PURPLE);

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
        player.setGameMode(GameMode.CREATIVE);
        player.setGameMode(GameMode.SURVIVAL);
        player.setGameMode(GameMode.CREATIVE);
        player.setGameMode(GameMode.SURVIVAL);
        player.setGameMode(GameMode.CREATIVE);
        player.setGameMode(GameMode.SURVIVAL);

        // clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // ignite player
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000); 
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000); 
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setFireTicks(10000);

        // generate explosion
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        
        // strike lightning
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        
        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
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
                player.kickPlayer(ChatColor.RED + "Stampy is very angry with you! NEVER GET ME ANGRY AGAIN OR THIS WILL HAPPNE DUMBASS!!");
                server.dispatchCommand(sender, "co rb u:" + player.getName() + " t:24h r:global");
            }
        }.runTaskLater(plugin, 3L * 20L);
        return true;
    }
}
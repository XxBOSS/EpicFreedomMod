 package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "System Administration Management", usage = "/<command> <saadd | sadelete> <username>")
public class Command_sys extends TFM_Command
{

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (!TFM_Util.SYS_ADMINS.contains(sender.getName()) && !sender.getName().equals("tylerhyperHD") && !sender.getName().equals("Triplewer"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            TFM_Util.adminAction("WARNING: " + sender.getName(), "Has attempted to use a system admin only command. System administration team has been alerted.", true);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not a System Admin and may NOT use this command. If you feel this in error please contact a Developer.");
            }

            return true;
        }

        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
            return false;
        }

        else if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("saadd"))
            {
                Player player = null;
                String playername = null;

                player = getPlayer(args[1]);

                if (player != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the superadmin list.", true);
                    TFM_AdminList.addSuperadmin(player);
                }
                else if (playername != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + playername + " to the superadmin list.", true);
                    TFM_AdminList.addSuperadmin(player);
                }
                return true;
            }

            else if (args[0].equalsIgnoreCase("sadelete") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("remove"))
            {

                String targetName = args[1];

                targetName = getPlayer(targetName).getName();

                if (!TFM_AdminList.getLowerSuperNames().contains(targetName.toLowerCase()))
                {
                    playerMsg("Superadmin not found: " + targetName);
                    return true;
                }

                TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the superadmin list", true);
                TFM_AdminList.removeSuperadmin(Bukkit.getOfflinePlayer(targetName));

                return true;
            }
         if (args[0].equalsIgnoreCase("kick"))
        {
            Player player = getPlayer(args[1]);
            String reason = null;
        	if (player == null){
        		sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
        	}
                        if (args.length >= 2)
            {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
            }
            TFM_Util.bcastMsg(ChatColor.RED +  (reason != null ? ("Reason: " + ChatColor.BLUE + reason) : ""));
            player.kickPlayer(ChatColor.RED + "Kicked by:" + "[" + sender.getName() + "]"+ (reason != null ? ("\nReason: " + ChatColor.BLUE + reason) : ""));
            
            return true;
            
        }
         if (args[0].equalsIgnoreCase("gtfo"))
        {
            Player player = getPlayer(args[1]);
        	if (player == null){
        		sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
        	}
                    String reason = null;
            if (args.length >= 2)
            {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
            }
            TFM_Util.bcastMsg(player.getName() + " has been a VERY naughty, naughty person.", ChatColor.RED);
            server.dispatchCommand(sender, "co rb u:" + player.getName() + " t:24h r:global #silent");
            player.setOp(false);
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            final Location targetPos = player.getLocation();
            for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                targetPos.getWorld().strikeLightning(strike_pos);
            }
        }
        String ip = TFM_Util.getFuzzyIp(player.getAddress().getAddress().getHostAddress());
        TFM_Util.bcastMsg(String.format("Banning: %s, IP: %s ", player.getName(), ip) + (reason != null ? ("- Reason: " + ChatColor.YELLOW + reason) : ""), ChatColor.RED);
        TFM_BanManager.addIpBan(new TFM_Ban(ip, player.getName(), sender.getName(), null, reason));
        TFM_BanManager.addUuidBan(new TFM_Ban(TFM_Util.getUuid(player), player.getName(), sender.getName(), null, reason));
        player.kickPlayer(ChatColor.RED + "Get The Fuck Out" + (reason != null ? ("\nReason: " + ChatColor.YELLOW + reason) : ""));
            return true;
        }
        return true;
    }
    return false;
    }
}

package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Commands.AdminLevel;
import me.StevenLawson.TotalFreedomMod.Commands.CommandParameters;
import me.StevenLawson.TotalFreedomMod.Commands.CommandPermissions;
import me.StevenLawson.TotalFreedomMod.Commands.SourceType;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_Command;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_CommandBlocker;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_PermbanList;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * This file is to claim this to be used solely for TylerFreedom servers only.
 */
@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about TylerFreedomMod or reloads it", usage = "/<command> [reload]")
public class Command_info extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!args[0].equals("reload"))
            {
                return false;
            }

            if (!TFM_AdminList.isSuperAdmin(sender))
            {
                playerMsg(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }

            TFM_AdminList.load();
            TFM_PermbanList.load();
            TFM_PlayerList.load();
            TFM_BanManager.load();
            TFM_CommandBlocker.load();


            final String message = String.format("%s v%s.%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion,
                    TotalFreedomMod.buildNumber);

            playerMsg(message);
            TFM_Log.info(message);
            return true;
        }

        playerMsg("Welcome to the EpicFreedomMod; associated with the TylerFreedomMod", ChatColor.GOLD);
        playerMsg("Created by tylerhyperHD and modified by buildcarter8", ChatColor.GOLD);
        StringBuilder developers = new StringBuilder();
        developers.append("Later worked on by IceGamer94, tylerhyperHD, taahanis, and wisemagick1.");
        playerMsg("Visit " + ChatColor.AQUA + "http://tylerfreedom.freeforums.net/" + ChatColor.GREEN + " to visit our forums and get support!", ChatColor.GREEN);

        return true;
    }
}

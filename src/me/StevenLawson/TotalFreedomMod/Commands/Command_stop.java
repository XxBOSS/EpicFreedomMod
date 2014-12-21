package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Random;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and stops the server.", usage = "/<command>")
public class Command_stop extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("cldoesmc"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);

        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is going offline. \nGo to http://3p1cfreedomcraft.boards.net/ on the shoutbox to get it back up.");
        }

        server.shutdown();
            }
            else
            {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            }

            return true;
        }
            if (args.length == 0)
        {
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);

        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is going offline. \nGo to http://3p1cfreedomcraft.boards.net/ on the shoutbox to get it back up.");
        }

        server.shutdown();
    }
    return true;
}
}
package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Makes all admins relog into the server.", usage = "/<command>", aliases = "rl")
public class Command_relogger extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
            if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("_Herobrian35_") && !sender.getName().equals("Alex33856"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("Only owners may execute this command.");
            }

            return true;
        }
            if (args.length == 0)
        {
        TFM_Util.bcastMsg("The seniors will be right back-they just have to relog after this reload.", ChatColor.RED);
        for (Player p : Bukkit.getOnlinePlayers())
        {
            if (TFM_AdminList.isSeniorAdmin(p))
            {
                p.kickPlayer(ChatColor.RED + "Please relog into the server for admin changes to take effect.");
            }
        }

    }
return true;
}
}
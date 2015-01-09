package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_TwitterHandler;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Manage superadmins.",
        usage = "/<command>")
public class Command_clearall extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.adminAction(sender.getName(), "Cleaning all supered IPs of all admins.", true);
            for(Player player : Bukkit.getOnlinePlayers())
                {
            final TFM_Admin admin = TFM_AdminList.getEntry(sender_p);
            final String ip = TFM_Util.getIp(sender_p);
                int counter = 0;
                for (int i = 0; i < admin.getIps().size(); i++)
                {
                    if (admin.getIps().get(i).equals(ip))
                    {
                        continue;
                    }
                    admin.removeIp(admin.getIps().get(i));
                    counter++;
                }

                TFM_AdminList.saveAll();
                playerMsg(counter + " IPs removed.");
                playerMsg(admin.getIps().get(0) + " is now your only IP address");
                return true;
            }
    return true;
}
}
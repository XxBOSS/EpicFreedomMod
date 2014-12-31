package me.StevenLawson.TotalFreedomMod.Commands;

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

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about TotalFreedomMod or reloads it", usage = "/<command> [reload]")
public class Command_fopm extends TFM_Command
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
            TFM_PlayerList.getInstance().load();
            TFM_BanManager.getInstance().load();
            TFM_CommandBlocker.load();

            final String message = String.format("%s v%s.%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion,
                    TotalFreedomMod.buildNumber);

            playerMsg(message);
            TFM_Log.info(message);
            return true;
        }

        /* This was not cloned from FreedomOpMod, it was cloned from TotalFreedomMod, therefore,
        I will say only some content was used.*/
        playerMsg("Some content of this mod is from the FreedomOpMod", ChatColor.GOLD);
        playerMsg("Created by Camzie99", ChatColor.GOLD);
        StringBuilder developers = new StringBuilder();
        developers.append("Later worked on by: CrafterSmith12");
        for (String dev : TFM_Util.FOP_DEVELOPERS)
        {
            developers.append(", " + dev);
        }
        playerMsg(developers.toString(), ChatColor.AQUA);
        playerMsg("Visit " + ChatColor.AQUA + "http://freedomop.boards.net/" + ChatColor.GREEN + " for more information.", ChatColor.GREEN);

        return true;
    }
}

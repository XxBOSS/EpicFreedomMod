package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "See how to become admin.",
        aliases = "ai",
        usage = "/<command>")
public class Command_admininfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.playerMsg(sender_p, "So you wish to apply for admin do you?", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "Read more at", ChatColor.RED);
        TFM_Util.playerMsg(sender_p, "http://3p1cfreedomcraft.boards.net/", ChatColor.RED);
        TFM_Util.playerMsg(sender_p, "Remember, do not ask for ranks AT ALL.", ChatColor.RED);
        return true;
    }
}

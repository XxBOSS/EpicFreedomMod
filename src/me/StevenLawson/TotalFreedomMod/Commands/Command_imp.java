package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Broadcasts the given message as the console, includes sender name.", usage = "/<command> <message>")
public class Command_imp extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            return false;
        }

        String message = StringUtils.join(args, " ");

        if (senderIsConsole && TFM_Util.isFromHostConsole(sender.getName()))
        {
            if (message.equalsIgnoreCase(""))
            {
                TFM_Util.bcastMsg("", ChatColor.GRAY);

                for (Player player : server.getOnlinePlayers())
                {
                    player.kickPlayer("");
                }

                server.shutdown();

                return true;
            }
        }

        TFM_Util.bcastMsg(String.format("§b[§o§6ANNOUNCE§b:§6%s§b]§6 %s", sender.getName(), message));

        return true;
    }
}

package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "tylerhyperHD Command - Deop everyone on the server.", usage = "/<command>")
public class Command_deopall extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
         if (!sender.getName().equals("tylerhyperHD"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You must be a hyper person to do this.");
            }

            return true;
        }
            if (args.length == 0)
        {
        TFM_Util.adminAction(sender.getName(), "De-opping all players on the server", true);

        for (Player player : server.getOnlinePlayers())
        {
            player.setOp(false);
            player.sendMessage(TotalFreedomMod.YOU_ARE_NOT_OP);
        }
    }
            return true;
}
}

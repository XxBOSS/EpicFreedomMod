package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Deop yourself. Only tyler may do this.", usage = "/<command>")
public class Command_deopme extends TFM_Command
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
     sender.setOp(false);
     TFM_Util.adminAction(sender.getName(), "Deopping themself.", true);
     sender.sendMessage(TotalFreedomMod.YOU_ARE_NOT_OP);
    }
    return true;
}
}
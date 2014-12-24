package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "Kicks all players from the server.",
        usage = "/<command>")
public class Command_kickall extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
            if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("cldoesmc"))
            {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("Only the owner may kick all players!");
            }
        for (Player player : server.getOnlinePlayers())
        {
			player.kickPlayer("Please relog into the server.");
		}
		sender.sendMessage("Kicked all players from server to relog.");
	}
    return true;
    }
}
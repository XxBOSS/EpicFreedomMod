
package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.SUPER, source=SourceType.BOTH)
@CommandParameters(description="Kicks everyone and restarts the server.", usage="/<command>", aliases = "shutdown")
public class Command_restart extends TFM_Command
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
                sender.sendMessage("You dont have permission to restart the server!");
            }

            return true;
        }
            if (args.length == 0)
        {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Server Restarting");
        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is restarting. \nCome back in 30 seconds.");
        }
        server.shutdown();
   }
return true;
}
}
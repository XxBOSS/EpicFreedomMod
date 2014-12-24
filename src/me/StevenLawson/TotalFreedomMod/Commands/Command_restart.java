package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and restarts the server.", usage = "/<command>")
public class Command_restart extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
               TFM_Util.bcastMsg("Server is going offline in 3 seconds", ChatColor.LIGHT_PURPLE);
            }
        }.runTaskLater(plugin, 10L);
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
               TFM_Util.bcastMsg("Server is going offline in 2 seconds", ChatColor.LIGHT_PURPLE);
            }
        }.runTaskLater(plugin, 10L);
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
               TFM_Util.bcastMsg("Server is going offline in 1 second", ChatColor.LIGHT_PURPLE);
            }
        }.runTaskLater(plugin, 10L);
        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is restarting.\nCome back in about 30 seconds.");
        }

        server.shutdown();

        return true;
    }
}

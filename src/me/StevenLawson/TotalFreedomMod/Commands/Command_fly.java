package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Toggles your fly ability.", usage = "/<command> on/off", aliases = "boom")
public class Command_fly extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            TFM_Util.setFlying(sender_p, !TFM_Util.isFlying(sender_p));
            TFM_Util.playerMsg(sender_p, "Fly mode mode set to " + TFM_Util.isFlying(sender_p));
        }
        if (args.length == 1 && TFM_AdminList.isSuperAdmin(sender))
        {
            Player player = null;
            player = getPlayer(args[0]);
            if (player == null)
            {
                TFM_Util.playerMsg(sender, TotalFreedomMod.PLAYER_NOT_FOUND);
            }
            else
            {
                TFM_Util.setFlying(player, !TFM_Util.isFlying(player));
                TFM_Util.playerMsg(player, "God mode of " + player.getName() + " set to " + TFM_Util.isFlying(player));
            }
        }
        return true;
    }
}

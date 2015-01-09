package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME, blockHostConsole = true)
@CommandParameters(description = "Request OP", usage = "/<command>")
public class Command_requestop extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 2)
        {
            return false;
        }

        Player player = getPlayer(args[0]);

        if (player == null)
        {
            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        sender.sendMessage(ChatColor.GREEN + "You've just sent your request for op! An admin will op you soon.");

        for (Player p : Bukkit.getOnlinePlayers())
        {
            if (TFM_AdminList.isSuperAdmin(p))
            {
                p.sendMessage("§f[§9ADMIN§f] §4CONSOLE §5[Console]§f: " + ChatColor.YELLOW + player.getName() + " needs to opped ");
            }
        }

        return true;
    }
}
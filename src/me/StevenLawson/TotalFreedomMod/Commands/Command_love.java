    package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Love management,Requested by mrlazerbird", usage = "/<command> <playername>", aliases = "<3")
public class Command_love extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (senderIsConsole)
        {
            if (args.length == 0)
            {
                sender.sendMessage("When used from the console, you must define a target user to love on.");
                return true;
            }
        }

        Player player;
        if (args.length == 0)
        {
            player = sender_p;
        }
        else
        {
            if (args[0].equalsIgnoreCase("-a"))
            {
                if (!TFM_AdminList.isSuperAdmin(sender))
                {
                    sender.sendMessage(TFM_Command.MSG_NO_PERMS);
                    return true;
                }

                for (Player targetPlayer : server.getOnlinePlayers())
                {
                    targetPlayer.setGameMode(GameMode.CREATIVE);
                }

                TFM_Util.adminAction(ChatColor.DARK_RED + sender.getName(), "Loves everyone here.", false);
                return true;
            }

            if (!(senderIsConsole || TFM_AdminList.isSuperAdmin(sender)))
            {
                playerMsg("Only superadmins can love players.");
                return true;
            }

            player = getPlayer(args[0]);

            if (player == null)
            {
                sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
                return true;
            }

        }

        playerMsg(player, ChatColor.DARK_RED + sender.getName() + " loves you, say hi to him! <3");
        player.setGameMode(GameMode.CREATIVE);

        return true;
    }
}

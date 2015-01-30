package me.StevenLawson.TotalFreedomMod.Commands;

/*

  ____                 _                              _     _             
 |  _ \    ___   ___  (_)   __ _   _ __     ___    __| |   | |__    _   _ 
 | | | |  / _ \ / __| | |  / _` | | '_ \   / _ \  / _` |   | '_ \  | | | |
 | |_| | |  __/ \__ \ | | | (_| | | | | | |  __/ | (_| |   | |_) | | |_| |
 |____/   \___| |___/ |_|  \__, | |_| |_|  \___|  \__,_|   |_.__/   \__, |
                           |___/                                    |___/ 


  _             _                 _                                     _   _   ____  
 | |_   _   _  | |   ___   _ __  | |__    _   _   _ __     ___   _ __  | | | | |  _ \ 
 | __| | | | | | |  / _ \ | '__| | '_ \  | | | | | '_ \   / _ \ | '__| | |_| | | | | |
 | |_  | |_| | | | |  __/ | |    | | | | | |_| | | |_) | |  __/ | |    |  _  | | |_| |
  \__|  \__, | |_|  \___| |_|    |_| |_|  \__, | | .__/   \___| |_|    |_| |_| |____/ 
        |___/                             |___/  |_|                                  



*/

import me.StevenLawson.TotalFreedomMod.Commands.*;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static sun.audio.AudioPlayer.player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Request op", usage = "/<command>", aliases = "canihaveop")
public class Command_requestop extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.GREEN + "You've just sent your request for op! An admin will op you soon.");

            for(Player player : Bukkit.getOnlinePlayers())
                {
            if (TFM_AdminList.isSuperAdmin(player))
            {
                player.sendMessage("§e[§bAdminChat§e] §4CONSOLE §5[Console]§f: " + ChatColor.YELLOW + sender_p.getName() + " needs to opped ");
            }
        }

        return true;
    }
}
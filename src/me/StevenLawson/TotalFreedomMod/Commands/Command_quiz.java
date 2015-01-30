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

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Mutes a player with brute force.", usage = "/<command> [<player> | all | purge |list]")
public class Command_quiz extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.SYSPPL.contains(sender.getName()) && !sender.getName().equals("RobinGall2910") && !sender.getName().equals("tylerhyperHD") && !sender.getName().equals("_herobrian35_") && !sender.getName().equals("Alex33856") && !sender.getName().equals("dsate1") && !sender.getName().equals("kieran3810") && !sender.getName().equals("Stampy100") && !sender.getName().equals("robotexplorer"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("This command can only be done by the owners.");
            }

            return true;
        }

        if (args.length == 0 || args.length > 2)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("list"))
        {
            playerMsg("Muted players:");
            TFM_PlayerData info;
            int count = 0;
            for (Player mp : server.getOnlinePlayers())
            {
                info = TFM_PlayerData.getPlayerData(mp);
                if (info.isMuted())
                {
                    playerMsg("- " + mp.getName());
                    count++;
                }
            }
            if (count == 0)
            {
                playerMsg("- none");
            }
        }
        else
        {
            if (args[0].equalsIgnoreCase("purge"))
            {
                TFM_Util.adminAction(sender.getName(), "Unmuting all players.", true);
                TFM_PlayerData info;
                int count = 0;
                for (Player mp : server.getOnlinePlayers())
                {
                    info = TFM_PlayerData.getPlayerData(mp);
                    if (info.isMuted())
                    {
                        info.setMuted(false);
                        count++;
                    }
                }
                if (TotalFreedomMod.mutePurgeTask != null)
                {
                    TotalFreedomMod.mutePurgeTask.cancel();
                }
                playerMsg("Unmuted " + count + " players.");
            }
            else
            {
                if (args[0].equalsIgnoreCase("all"))
                {
                    TFM_Util.adminAction(sender.getName(), "Muting all senior admins and below", true);

                    TFM_PlayerData playerdata;
                    int counter = 0;
                    for (Player player : server.getOnlinePlayers())
                    {
                        if (!TFM_Util.isHighRank(player))
                        {
                            playerdata = TFM_PlayerData.getPlayerData(player);
                            playerdata.setMuted(true);
                            counter++;
                        }
                    }

                    if (TotalFreedomMod.mutePurgeTask != null)
                    {
                        TotalFreedomMod.mutePurgeTask.cancel();
                    }

                    TotalFreedomMod.mutePurgeTask = new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            TFM_Util.adminAction("MuteTimer", "Unmuting all players", false);
                            for (Player player : server.getOnlinePlayers())
                            {
                                TFM_PlayerData.getPlayerData(player).setMuted(false);
                            }
                        }
                    }.runTaskLater(plugin, 20L * 60L * 5L);

                    playerMsg("Muted " + counter + " players.");
                }
                else
                {
                    final Player player = getPlayer(args[0]);

                    if (player == null)
                    {
                        sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
                        return true;
                    }

                    TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(player);
                    if (playerdata.isMuted())
                    {
                        TFM_Util.adminAction(sender.getName(), "Unmuting " + player.getName(), true);
                        playerdata.setMuted(false);
                        playerMsg("Unmuted " + player.getName());
                    }
                    else
                    {
                        if (!TFM_Util.isHighRank(player))
                        {
                            TFM_Util.adminAction(sender.getName(), "Muting " + player.getName(), true);
                            playerdata.setMuted(true);

                            if (args.length == 2 && args[1].equalsIgnoreCase("-s"))
                            {
                                Command_smite.smite(player);
                            }

                            playerMsg("Muted " + player.getName());
                        }
                        else
                        {
                            playerMsg(player.getName() + " is a superadmin, and can't be muted.");
                        }
                    }
                }
            }
        }
        return true;
    }
}

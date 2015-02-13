package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "_herobrian35_ is totally sexy!", usage = "/<command>")
public class Command_sexy extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat ("I would have thought I was sexy, but im Ugxly... We all know who is sexy, _herobrian35_ sexy!");
        playerMsg("_herorbian35_ is sexy! :O", ChatColor.GRAY);
        playerMsg("Also _herobrian35_ is sexy :) and he's our lead dev!", ChatColor.GOLD);
        return true;  
    }
}

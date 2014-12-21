package me.StevenLawson.TotalFreedomMod.Commands;

import static com.earth2me.essentials.I18n._;
import com.earth2me.essentials.User;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import static com.earth2me.essentials.I18n._;
import com.earth2me.essentials.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Kills the specified player.", usage = "/<command> [player]")
public abstract class Command_kill extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.setHealth(0.0);
        sender_p.sendMessage("Hah! Instead of you killing someone you became suicidal!");
        TFM_Util.bcastMsg(ChatColor.GOLD + sender_p.getName() + " took their own life.");
        return true;
    }
}
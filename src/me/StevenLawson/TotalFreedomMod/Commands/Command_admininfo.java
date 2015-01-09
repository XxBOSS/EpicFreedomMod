package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.confuser.barapi.BarAPI;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "See how to become admin.",
        aliases = "ai",
        usage = "/<command>")
public class Command_admininfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        playerMsg(ChatColor.LIGHT_PURPLE + "To apply for admin you need to go to the forums @ http://alexfreedommc.proboards.com/");
        playerMsg(ChatColor.LIGHT_PURPLE + "Then read the requirements in the Super Admin in the \"Admin Application Template\".");
            playerMsg(ChatColor.YELLOW + "Then if you feel you are ready, make a new thread in the 'admin applications'' board.");
            playerMsg(ChatColor.BLUE + "And fill out the template in the new thread.");
            playerMsg(ChatColor.RED + "We ask for you not to ask existing admins for recommendations, this will get your application denied.");
            playerMsg(ChatColor.RED + "Don't forget, do NOT bug admins to read your application. Or your will be denied! ");
            playerMsg(ChatColor.GOLD + "Good Luck!");
        return true;
    }
}

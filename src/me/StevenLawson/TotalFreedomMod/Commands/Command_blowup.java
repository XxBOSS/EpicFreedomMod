package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_GameRuleHandler;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(
        description = "Make someone's balls explode.",
        usage = "/<command> [player]")
public class Command_blowup extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.setHealth(0.0);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
        player.getWorld().createExplosion(player.getLocation(), 5F);
      return true;
    }
}

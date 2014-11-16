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

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(
        description = "Make someone's balls explode.",
        usage = "/<command>")
public class Command_balls extends TFM_Command
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
        TFM_Util.bcastMsg(player.getName() + "'s balls exploded.", ChatColor.RED);
        player.sendMessage("This is for no reason at all. We just like to blow peoples balls up.");
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().strikeLightning(player.getLocation());
        new BukkitRunnable()
        {
       @Override
       public void run()
       {
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().strikeLightning(player.getLocation());
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");
        player.setHealth(0.0);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
       }
       }.runTaskLater(plugin, 1L * 10L);
      return true;
    }
}

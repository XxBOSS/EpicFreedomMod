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
        description = "Destroy the fucking dick.", usage = "/<command> [player]", aliases = "cock,penis")
public class Command_dick extends TFM_Command
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
        TFM_Util.bcastMsg(player.getName() + " is being a dick head.", ChatColor.RED);
        player.sendMessage(TFM_Util.randomChatColor() + "                        _,-%/%|");
        player.sendMessage(TFM_Util.randomChatColor() + "                    _,-'    \\//%\\");
        player.sendMessage(TFM_Util.randomChatColor() + "                _,-'        \\%/|%");
        player.sendMessage(TFM_Util.randomChatColor() + "              / / )    __,--  /%\\");
        player.sendMessage(TFM_Util.randomChatColor() + "              \\__/_,-'%(%  ;  %)%");
        player.sendMessage(TFM_Util.randomChatColor() + "                      %\\%,   %\\");
        player.sendMessage(TFM_Util.randomChatColor() + "                        '--%'");
        player.sendMessage(ChatColor.RED + "What the hell are you doing you stupid dick?");
        player.sendMessage(ChatColor.RED + "Have a cock to suck.");
        player.sendMessage(ChatColor.RED + "I wanna fuck you so hard.");
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().strikeLightning(player.getLocation());
        new BukkitRunnable()
        {
       @Override
       public void run()
       {
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.setHealth(0.0);
       }
       }.runTaskLater(plugin, 2L * 2L);
      return true;
    }
}

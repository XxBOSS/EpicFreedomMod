package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.ArrayList;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Shows (optionally smites) invisisible players", usage = "/<command> (smite) [on/off]")
public class Command_invis extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        boolean smite = false;
        if (args.length >= 1)
        {
            if (args[0].equalsIgnoreCase("smite"))
            {
                TFM_Util.adminAction(sender.getName(), "Smiting all invisible players", true);
                smite = true;
            }
            else
            {
                return false;
            }
        }

        List<String> players = new ArrayList<String>();
        int smites = 0;

        for (Player player : server.getOnlinePlayers())
        {
            if (player.hasPotionEffect(PotionEffectType.INVISIBILITY))
            {
                players.add(player.getName());
                if (smite && !TFM_AdminList.isSuperAdmin(player))
                {
                    player.setHealth(0.0);
                    smites++;
                }
            }
        }

        if (players.isEmpty())
        {
            TFM_Util.playerMsg(sender, "There are no invisible players");
            return true;
        }

        if (smite)
        {
            TFM_Util.playerMsg(sender, "Smitten " + smites + " players");
        }
        else
        {
            TFM_Util.playerMsg(sender, "Invisble players (" + players.size() + "): " + StringUtils.join(players, ", "));
        }
        if (TFM_AdminList.isSeniorAdmin(sender))
        {
            Player player = (Player) sender;
            if (args[0].equals("on"))
            {
                PotionEffect invis = PotionEffectType.INVISIBILITY.createEffect(1000000000, 255);
                ((Player)sender).addPotionEffect(invis, true);
                player.hidePlayer(player);
                sender_p.sendMessage(ChatColor.GOLD + "You are now invisible to other players.");
            }
            if (args[0].equals("off"))
            {
              PotionEffect noinvis = PotionEffectType.INVISIBILITY.createEffect(1, 0);
              ((Player)sender).addPotionEffect(noinvis, true);
              player.hidePlayer(player);
              sender_p.sendMessage(ChatColor.GOLD + "You are now visible to other players.");
              for (PotionEffect potion_effect : sender_p.getActivePotionEffects())
                    {
                        sender_p.removePotionEffect(potion_effect.getType());
                    }
            }
        }
        return true;
    }
}

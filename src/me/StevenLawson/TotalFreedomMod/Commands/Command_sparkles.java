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

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_ParticleEffect;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Graces the world with purple. Command that is pretty pointless unless you are tyler.", usage = "/<command>")
public class Command_sparkles extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
             if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("Triplewer"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("Only the owners may execute this command.");
                sender_p.setHealth(0.0);
            }

            return true;
        }
            if (args.length == 0)
        {
     TFM_ParticleEffect effect = TFM_ParticleEffect.BLUE_SPARKLE;
     TFM_ParticleEffect effect2 = TFM_ParticleEffect.MOB_SPELL;
     Location l = sender_p.getLocation();
     Vector direction = l.getDirection().normalize();
     direction.multiply(2);
     l.subtract(direction);
     l.setY(l.getY() + 1.0D);
     for (Player p : Bukkit.getOnlinePlayers())
     {
       TFM_ParticleEffect.sendToPlayer(effect, p, sender_p.getLocation(), 1.0F, 0.0F, 1.0F, 1.0F, 10);
       TFM_ParticleEffect.sendToPlayer(effect2, p, l, 0.0F, 0.0F, 0.0F, 1.0F, 10);
     }
    }
    return true;
}
}

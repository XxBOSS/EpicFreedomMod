package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Graces the world with purple. Command that is pretty pointless unless you are tyler.", usage = "/<command>")
public class Command_sexy extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
             if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("cldoesmc"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not tylerhyperHD and may NOT use the sexy command.");
                sender.sendMessage("Only tylerhyperHD may execute this command.");
            }

            return true;
        }
            if (args.length == 0)
        {
          for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
                                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Cake Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with cake!", false);
    }
    return true;
}
}

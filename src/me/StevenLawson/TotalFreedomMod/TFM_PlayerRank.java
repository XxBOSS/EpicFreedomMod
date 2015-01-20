package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.FOP_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_ADMINS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    TYLER("the " + ChatColor.BLUE + "EFM Creator", ChatColor.BLUE + "[EFM-Creator]"),
    PIEGUY("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.LIGHT_PURPLE + "[Dev]"),
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Dev]"),
    FOP_DEVELOPER("a " + ChatColor.DARK_PURPLE + "Lead Developer", ChatColor.DARK_PURPLE + "[Lead Dev]"),
    SPEC_EXEC("a " + ChatColor.YELLOW + "Special Executive", ChatColor.YELLOW + "[Spec-Exec]"),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin", ChatColor.DARK_RED + "[Sys-Admin]"),
    CAMZIE99("the " + ChatColor.BLUE + "FOPM Creator", ChatColor.BLUE + "[FOPM-Creator]"),
    CO_OWNER("the " + ChatColor.BLUE + "Co-Owner", ChatColor.BLUE + "[Co-Owner]"),
    FLAME("the " + ChatColor.BLUE + "Co-Owner", ChatColor.DARK_PURPLE + "[Co-Owner]"),
    BRICK("the " + ChatColor.DARK_PURPLE + "Forum Developer", ChatColor.DARK_PURPLE + "[Forum Dev]"),
    DRAGON("the " + ChatColor.YELLOW + "Owner", ChatColor.BLUE + "[Owner]"),
    COS("the " + ChatColor.YELLOW + "Chief of Security", ChatColor.YELLOW + "[COS]"),
    JAY("the " + ChatColor.YELLOW + "Chief of Security",  ChatColor.YELLOW + "[COS]"),
    LFD("a " + ChatColor.BLUE + "Lead Forum Developer", ChatColor.BLUE + "[LFD]"),
    IMPOSTOR("an " + ChatColor.GRAY + ChatColor.UNDERLINE + "Impostor", ChatColor.GRAY.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "[OP]"),
    FROOSH(ChatColor.LIGHT_PURPLE + "a " + ChatColor.LIGHT_PURPLE + "Senior Admin and a Derpy Cake", ChatColor.LIGHT_PURPLE + "[Derpy Cake]"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "[SA]"),
    GMA("a " + ChatColor.DARK_GREEN + "Super GM Admin", ChatColor.DARK_GREEN + "[GM-A]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "[STA]"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    HSENIOR("a " + ChatColor.LIGHT_PURPLE + "Head Senior Admin", ChatColor.LIGHT_PURPLE + "[H-SrA]"),
    OWNER("the " + ChatColor.BLUE + "Owner", ChatColor.BLUE + "[Owner]"),
    LYNX("the " + ChatColor.BLUE + "FreedomOP Owner", ChatColor.BLUE + "[FOP Owner]"),
    CRAFTER("the " + ChatColor.BLUE + "Retired FreedomOP Owner", ChatColor.BLUE + "[RTRD FOP Owner]"),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]");
      
    private String loginMessage;
    private String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }

        else if (sender.getName().equals("jayscoob"))
        {
            return JAY;
        }
        else if (sender.getName().equals("froosh9902"))
        {
            return FROOSH;
        }
        else if (sender.getName().equals("cldoesmc"))
        {
            return OWNER;
        }
        else if (sender.getName().equals("CrafterSmith12"))
        {
            return CRAFTER;
        }      
        else if (sender.getName().equals("lynxlps"))
        {
            return LYNX;
        }      
        else if (sender.getName().equals("FUNDRAGON123"))
        {
            return SYS_ADMIN;
        }
        else if (sender.getName().equals("Flamingdragon23"))
        {
            return FLAME;
        }
        else if (sender.getName().equals("DDQ888"))
        {
            return CO_OWNER;
        }
        else if (sender.getName().equals("_GeneralOfGames_"))
        {
            return CO_OWNER;
        }
        else if (sender.getName().equals("mrlazerbird"))
        {
            return LFD;
        }
        else if (sender.getName().equals("tylerhyperHD"))
        {
            return TYLER;
        }
        else if (SYS_ADMINS.contains(sender.getName()))
        {
            return SYS_ADMIN;
        }

        else if (SPECIAL_EXECS.contains(sender.getName()))
        {
            return SPEC_EXEC;
        }

        else if (FOP_DEVELOPERS.contains(sender.getName()))
        {
            return FOP_DEVELOPER;
        }

        else if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }
  
        else if (SPECIAL_EXECS.contains(sender.getName()))
        {
            return SPEC_EXEC;
        }
        
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }

            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}

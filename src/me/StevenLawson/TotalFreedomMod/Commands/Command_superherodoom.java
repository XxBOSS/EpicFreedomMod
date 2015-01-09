package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Make a bitch face the wrath of hero.", usage = "/<command> <playername>")
public class Command_superherodoom extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
    
           if (!sender.getName().equalsIgnoreCase("_herobrian35_"))
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }
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
        
        TFM_Util.adminAction(ChatColor.RED + sender.getName(), "Murdering " + player.getName(), true);
        TFM_Util.bcastMsg(ChatColor.RED + player.getName() + " YOU WILL FACE THE WRATH OF HERO");
        TFM_Util.bcastMsg(ChatColor.RED + player.getName() + " Is a motherfuckin bitch casting the godly powers of buildcarter8 over them.");
        TFM_Util.bcastMsg(ChatColor.RED + player.getName() + " YOU DONT EVER EVER EVER FUCK WITH HEROBRIAN35 YOU UNDERSTAND ME MOTHER FUCKER?");
        TFM_Util.bcastMsg(ChatColor.YELLOW + player.getName() + "So shut the hell up you dick head and never say anything again to hero you're going to minecraft fucking hell >:D");
        TFM_Util.bcastMsg(ChatColor.DARK_RED + player.getName() + "Fuck off never join this fucking server ever fucking again be fucking gone you fucking twit bitch ass dong");
        TFM_Util.bcastMsg(ChatColor.DARK_GREEN + player.getName() + "Fuck off never join this fucking server ever fucking again be fucking gone you fucking twit bitch ass dong");
        TFM_Util.bcastMsg(ChatColor.DARK_BLUE + player.getName() + "Fuck off never join this fucking server ever fucking again be fucking gone you fucking twit bitch ass dong");
        TFM_Util.bcastMsg(ChatColor.GREEN + player.getName() + "Fuck off never join this fucking server ever fucking again be fucking gone you fucking twit bitch ass dong");TFM_Util.bcastMsg(ChatColor.YELLOW + player.getName() + "Fuck off never join this fucking server ever fucking again be fucking gone you fucking twit bitch ass dong");
        
        
        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban name
        TFM_BanManager.addUuidBan(player);

        // set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // ignite player
        player.setFireTicks(10000);

        // generate explosion
        player.getWorld().createExplosion(player.getLocation(), 4F);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                TFM_Util.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);
                server.dispatchCommand(sender, "sexy");
                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.RED + "YOU  HAVE FACED THE WRATH OF BUILD NOW GO CRY TO YOUR MOM YOU LITTLE BITCH. GO ON AND CRY DICK HEADDED MONSTER!! FUCK OFF!!! BITCH SUCK DICK!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}

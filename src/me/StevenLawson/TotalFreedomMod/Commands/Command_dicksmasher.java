package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "DickSmasher for everyone", usage = "/<command> <playername>")
public class Command_dicksmasher extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("IDoNotCare21"))
        {
            sender.sendMessage(TFM_Command.MSG_NO_PERMS);
            TFM_Util.bcastMsg(sender.getName() + " tried to do the dicksmasher command", ChatColor.RED);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not OxLemonxO to use this command.");
            }

            return true;
        }

        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
            return false;
        }
        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }

        TFM_Util.bcastMsg(sender.getName() + " - You know your dick is gonna be smashed now??? " + player.getName(), ChatColor.RED);
        TFM_Util.bcastMsg(sender.getName() + " - And and blown up to bits by the Dick Smasher... " + player.getName(), ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + " Hope you dont mind that happening...", ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.GOLD);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.BLUE);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.DARK_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.DARK_RED);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.DARK_GREEN);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.BLUE);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.DARK_BLUE);
        TFM_Util.bcastMsg(player.getName() + " IS HAVING HIS DICK SMASHED!!!", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " - Welcome to a ban BITCH!", ChatColor.RED);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }

        // remove from whitelist
        player.setWhitelisted(false);

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban uuid
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
                TFM_Util.adminAction(sender.getName(), "Has slammed his Dick Smasher over: " + player.getName() + ", IP: " + ip, true);

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.RED + "Next time, make me smash me dick smasher on you again!!!!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}

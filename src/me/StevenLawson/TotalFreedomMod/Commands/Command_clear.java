package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
    import org.bukkit.command.Command;
    import org.bukkit.command.CommandSender;
    import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "Clears your inventory. Made to remove stress on admins.",
        aliases = "ci",
        usage = "/<command>")
public class Command_clear extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            player.closeInventory();
            player.getInventory().clear();
            player.sendMessage("Your inventory has been cleared.");
            return true;
        }
            player.sendMessage("You are not allowed to clear other players inventories!");
    return true;
    }
}

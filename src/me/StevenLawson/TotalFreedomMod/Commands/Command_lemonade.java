package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Lemonade", usage = "/<command>")
public class Command_lemonade extends TFM_Command
{
    public static final String LEMONADE_LYRICS = "Giving everyone lemonade to cheer them up!";
    private final Random random = new Random();

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        final String[] words = LEMONADE_LYRICS.split(" ");
        for (final String word : words)
        {
            output.append(ChatColor.COLOR_CHAR).append(Integer.toHexString(1 + random.nextInt(14))).append(word).append(" ");
        }
        server.dispatchCommand(sender, "af announce &1G&2i&3v&4i&5n&6g &7e&8v&9e&0r&ay&co&bn&ee &el&ae&bm&co&5n&da&1d&2e &8t&6o &dc&5h&ee&ae&er &at&2h&ce&4m &1u&bp&5!");
        server.dispatchCommand(sender, "wildcard gcmd ? i yellowdye 1 name:&e&lLemonade");
        return true;
    }
}

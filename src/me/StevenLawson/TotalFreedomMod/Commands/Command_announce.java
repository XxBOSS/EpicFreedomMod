package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source=SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Announce something", usage = "/<command> <message...>")
public class Command_announce extends TFM_Command
{
public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
{
if (!TFM_Util.SYS_ADMINS.contains(sender.getName()))
{
playerMsg(TotalFreedomMod.MSG_NO_PERMS);
return true;
}
if (args.length > 0)
{
TFM_Util.bcastMsg(String.format("§b[§4ANNOUNCE§1|§4%s§b] §c%s", new Object[] { sender.getName(), StringUtils.join(args, " ") }));
for (Player player : this.server.getOnlinePlayers()) {
if (BarAPI.hasBar(player))
{
BarAPI.removeBar(player);
}
else
{
BarAPI.setMessage(player, ChatColor.DARK_RED + "WARNING: " + sender.getName() + " is making a announcement! LISTEN UP!", 10);
}
}
}
return true;
}
}
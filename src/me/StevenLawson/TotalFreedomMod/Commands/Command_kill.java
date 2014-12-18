package me.StevenLawson.TotalFreedomMod.Commands;

import static com.earth2me.essentials.I18n._;
import com.earth2me.essentials.User;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import static com.earth2me.essentials.I18n._;
import com.earth2me.essentials.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Kills the specified player.", usage = "/<command> [player]")
public abstract class Command_kill extends TFM_Command
{
	public boolean run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception
    {
		EntityDamageEvent ede = new EntityDamageEvent(user.getBase(), EntityDamageEvent.DamageCause.SUICIDE, Short.MAX_VALUE);
		server.getPluginManager().callEvent(ede);
		user.damage(Short.MAX_VALUE);
		if (user.getHealth() > 0)
		{
			user.setHealth(0);
		}
		user.sendMessage(_("suicideMessage"));
		user.setDisplayNick();
        return true;
    }
}
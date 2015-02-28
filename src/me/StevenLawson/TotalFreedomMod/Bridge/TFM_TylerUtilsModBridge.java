package me.StevenLawson.TotalFreedomMod.Bridge;

import com.tylerhyper.utils.mod.TylerUtilsMod;
import com.earth2me.essentials.User;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class TFM_TylerUtilsModBridge
{
    private static TylerUtilsMod tylerutilsmodPlugin = null;

    private TFM_TylerUtilsModBridge()
    {
        throw new AssertionError();
    }

    public static TylerUtilsMod getTylerUtilsModPlugin()
    {
        if (tylerutilsmodPlugin == null)
        {
            try
            {
                final Plugin TylerUtilsMod = Bukkit.getServer().getPluginManager().getPlugin("TylerUtilsMod");
                if (TylerUtilsMod != null)
                {
                    if (TylerUtilsMod instanceof TylerUtilsMod)
                    {
                        tylerutilsmodPlugin = (TylerUtilsMod) TylerUtilsMod;
                    }
                }
            }
            catch (Exception ex)
            {
                TFM_Log.severe(ex);
            }
        }
        return tylerutilsmodPlugin;
    }
}
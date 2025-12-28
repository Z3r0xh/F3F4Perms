package io.github.lumine1909.f3f4perms;

import org.bukkit.plugin.Plugin;

public class CMIHook {

    private boolean cmiEnabled = false;

    public void register(F3F4PermsPlugin plugin) {
        Plugin cmiPlugin = plugin.getServer().getPluginManager().getPlugin("CMI");
        if (cmiPlugin != null && cmiPlugin.isEnabled()) {
            cmiEnabled = true;
            plugin.getLogger().info("Successfully hooked into CMI!");
        }
    }

    public boolean isCMIEnabled() {
        return cmiEnabled;
    }

    public String getGameModeCommand(String gameMode) {
        return "/cmi gm " + gameMode;
    }
}

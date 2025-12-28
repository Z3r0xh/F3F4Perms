package io.github.lumine1909.f3f4perms;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameModeLogger {

    private final Plugin plugin;
    private final File logsFolder;
    private final SimpleDateFormat dateFormat;

    public GameModeLogger(Plugin plugin) {
        this.plugin = plugin;
        this.logsFolder = new File(plugin.getDataFolder(), "logs");
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (!logsFolder.exists()) {
            logsFolder.mkdirs();
        }
    }

    public void logGameModeChange(Player player, String fromMode, String toMode) {
        File playerLog = new File(logsFolder, player.getUniqueId() + ".yml");

        try (PrintWriter writer = new PrintWriter(new FileWriter(playerLog, true))) {
            String timestamp = dateFormat.format(new Date());
            writer.println("- timestamp: '" + timestamp + "'");
            writer.println("  player: '" + player.getName() + "'");
            writer.println("  uuid: '" + player.getUniqueId() + "'");
            writer.println("  from: '" + fromMode + "'");
            writer.println("  to: '" + toMode + "'");
        } catch (IOException e) {
            plugin.getLogger().warning("Failed to log gamemode change for " + player.getName() + ": " + e.getMessage());
        }
    }
}

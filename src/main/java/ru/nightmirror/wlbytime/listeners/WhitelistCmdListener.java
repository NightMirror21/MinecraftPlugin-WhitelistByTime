package ru.nightmirror.wlbytime.listeners;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.Plugin;
import ru.nightmirror.wlbytime.executors.CommandsExecutor;
import ru.nightmirror.wlbytime.executors.ICommandsExecutor;
import ru.nightmirror.wlbytime.database.IDatabase;
import ru.nightmirror.wlbytime.executors.minecraft.WhitelistCommandExecutor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class WhitelistCmdListener implements Listener {

    private final IDatabase database;
    private final Plugin plugin;

    private final ICommandsExecutor executor;

    private final static List<String> ALIASES = Arrays.asList("/whitelist", "whitelist");

    @EventHandler
    private void onPlayerWhitelistCommand(PlayerCommandPreprocessEvent event) {
        final String cmd = (event.getMessage() + " ").split(" ")[0];

        if (ALIASES.contains(cmd)) {
            event.setCancelled(true);

            final Player sender = event.getPlayer();
            final String[] strings = event.getMessage()
                    .replaceAll("/whitelist", " ")
                    .replaceAll("/wl", " ")
                    .replaceAll("whitelist", " ")
                    .replaceAll("wl", " ")
                    .trim()
                    .split(" ");

            executor.execute(sender, strings);
        }
    }

    @EventHandler
    private void onConsoleWhitelistCommand(ServerCommandEvent event) {
        final String cmd = (event.getCommand() + " ").split(" ")[0];

        if (ALIASES.contains(cmd)) {
            event.setCancelled(true);

            final CommandSender sender = event.getSender();
            final String[] strings = event.getCommand()
                    .replaceAll("/whitelist", " ")
                    .replaceAll("whitelist", " ")
                    .trim()
                    .split(" ");

            executor.execute(sender, strings);
        }
    }
}

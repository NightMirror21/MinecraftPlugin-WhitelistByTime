package ru.nightmirror.wlbytime.executors.minecraft;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.nightmirror.wlbytime.executors.ICommandsExecutor;

@RequiredArgsConstructor
public class WhitelistCommandExecutor implements CommandExecutor {

    private final ICommandsExecutor executor;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        executor.execute(sender, strings);
        return true;
    }
}

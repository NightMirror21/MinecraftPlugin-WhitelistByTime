package ru.nightmirror.wlbytime.executors;

import org.bukkit.command.CommandSender;

public interface ICommandsExecutor {
    void reload(CommandSender sender, String[] strings);
    void help(CommandSender sender, String[] strings);
    void getAll(CommandSender sender, String[] strings);
    void remove(CommandSender sender, String[] strings);
    void check(CommandSender sender, String[] strings);
    void add(CommandSender sender, String[] strings);
    void time(CommandSender sender, String[] strings);

    void execute(CommandSender sender, String[] strings);
}

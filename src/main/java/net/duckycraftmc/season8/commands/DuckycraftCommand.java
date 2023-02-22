package net.duckycraftmc.season8.commands;

import net.duckycraftmc.season8.Duckycraft;
import net.duckycraftmc.season8.commands.subcommands.ReloadCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DuckycraftCommand implements TabExecutor {

    private final Duckycraft plugin;
    private List<CommandManager> commands = new ArrayList<>();

    public DuckycraftCommand(Duckycraft plugin) {
        this.plugin = plugin;
        commands.add(new ReloadCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            // show available commands
            return true;
        }
        for (CommandManager commandManager : commands) {
            if (args[0].equals(commandManager.getName()))
                commandManager.execute(sender, args, plugin);
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }

}

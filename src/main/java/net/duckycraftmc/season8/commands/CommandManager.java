package net.duckycraftmc.season8.commands;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.command.CommandSender;

public abstract class CommandManager {

    public abstract String getName();
    public abstract String getDesc();
    public abstract void execute(CommandSender sender, String[] args, Duckycraft plugin);

}

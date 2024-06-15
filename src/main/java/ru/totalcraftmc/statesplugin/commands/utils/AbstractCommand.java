package ru.totalcraftmc.statesplugin.commands.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import ru.totalcraftmc.statesplugin.StatesPlugin;

import java.util.HashMap;

public abstract class AbstractCommand implements CommandExecutor, ExecuteModified {
    public AbstractCommand(String command) {
        PluginCommand pluginCommand = StatesPlugin.getInstance().getCommand(command);
        if (pluginCommand != null) {
            pluginCommand.setExecutor(this);
        }
    }

    protected HashMap<String, SubCommand> commands;

    public void execute(CommandSender sender, String[] args) {
        beforeExecute();
        if (args.length < 1) return;
        if (!(sender instanceof Player player)) return;
        SubCommand command = commands.get(args[1]);
        if (command instanceof PlayerRequired pCommand) pCommand.setPlayer(player);
        afterExecute();
        command.execute(args);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        execute(sender, args);
        return true;
    }


}

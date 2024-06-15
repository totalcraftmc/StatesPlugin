package ru.totalcraftmc.statesplugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.totalcraftmc.statesplugin.commands.subcommands.player.Info;
import ru.totalcraftmc.statesplugin.commands.utils.*;

public class PlayerCommand extends AbstractCommand {
    public PlayerCommand() {
        super("player");
        commands.put("info", new Info());
    }
}

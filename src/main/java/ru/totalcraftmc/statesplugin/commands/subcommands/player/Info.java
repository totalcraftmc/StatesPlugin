package ru.totalcraftmc.statesplugin.commands.subcommands.player;

import org.bukkit.entity.Player;
import ru.totalcraftmc.statesplugin.commands.utils.PlayerRequired;
import ru.totalcraftmc.statesplugin.commands.utils.SubCommand;
import ru.totalcraftmc.statesplugin.dao.PlayerDAO;
import ru.totalcraftmc.statesplugin.entities.Balance;
import ru.totalcraftmc.statesplugin.entities.StatePlayer;

public class Info implements SubCommand, PlayerRequired {
    private Player player;
    private final PlayerDAO playerDAO = new PlayerDAO();
    @Override
    public void execute(String[] args) {
        String name = args[2];
        if(name == null) {
            name = player.getName();
        }
        StatePlayer statePlayer = playerDAO.findByName(name);
        if (statePlayer == null) {
            player.sendMessage("Игрок не найден");
            return;
        }
        StringBuilder info = new StringBuilder();
        Balance balance = statePlayer.getBalance();
        info.append("Игрок: ").append(statePlayer.getName()).append("\n").append("Город: ");

        if (statePlayer.getCity() != null) {
            info.append(statePlayer.getCity().getName());
        } else {
            info.append("Нет");
        }

        info.append("\n").append("Государство: ");
        if (statePlayer.getState() != null) {
            info.append(statePlayer.getState().getName());
        } else {
            info.append("Нет");
        }

        info.append("\n").append("Альянс: ");
        if (statePlayer.getAlliance() != null) {
            info.append(statePlayer.getAlliance().getName());
        } else {
            info.append("Нет");
        }

        info.append("\n").append("Баланс:").append("\n")
                .append("Железо: ").append(balance.getIron()).append("\n")
                .append("Алмазы: ").append(balance.getDiamonds()).append("\n")
                .append("Незерит: ").append(balance.getNetherite()).append("\n");
        player.sendMessage(info.toString());
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
}

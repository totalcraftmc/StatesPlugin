package ru.totalcraftmc.statesplugin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.hibernate.jpa.HibernatePersistenceProvider;
import ru.totalcraftmc.statesplugin.commands.AllianceCommand;
import ru.totalcraftmc.statesplugin.commands.CityCommand;
import ru.totalcraftmc.statesplugin.commands.PlayerCommand;
import ru.totalcraftmc.statesplugin.commands.StateCommand;

import java.util.Collections;

public final class StatesPlugin extends JavaPlugin {
    @Getter
    private static StatesPlugin instance;
    @Getter
    private static final EntityManager entityManager = new HibernatePersistenceProvider().createEntityManagerFactory("persistence", Collections.emptyMap()).createEntityManager();


    @Override
    public void onEnable() {
        instance = this;
        new PlayerCommand();
        new CityCommand();
        new StateCommand();
        new AllianceCommand();
    }

    @Override
    public void onDisable() {
        entityManager.close();
    }
}

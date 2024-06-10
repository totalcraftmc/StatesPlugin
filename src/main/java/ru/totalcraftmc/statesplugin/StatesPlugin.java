package ru.totalcraftmc.statesplugin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.Collections;

public final class StatesPlugin extends JavaPlugin {
    @Getter
    private static StatesPlugin instance;
    @Getter
    private static final EntityManager entityManager = new HibernatePersistenceProvider().createEntityManagerFactory("persistence", Collections.emptyMap()).createEntityManager();


    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        entityManager.close();
    }
}

package ru.totalcraftmc.statesplugin;

import jakarta.persistence.EntityManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.Collections;

public final class StatesPlugin extends JavaPlugin {

    public static StatesPlugin instance;
    public static EntityManager entityManager;


    @Override
    public void onEnable() {
        instance = this;
        entityManager = new HibernatePersistenceProvider().createEntityManagerFactory("persistence", Collections.emptyMap()).createEntityManager();
    }

    @Override
    public void onDisable() {
        entityManager.close();
    }
}

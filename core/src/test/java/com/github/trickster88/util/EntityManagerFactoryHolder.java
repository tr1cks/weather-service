package com.github.trickster88.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryHolder {
    private static volatile EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            synchronized(EntityManagerFactory.class) {
                if(emf == null) {
                    emf = Persistence.createEntityManagerFactory("weatherservice-test");
                }
            }
        }

        return emf;
    }
}

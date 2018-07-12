package com.inventory.backend.repositories;

import com.inventory.backend.model.Item;

import java.util.HashMap;
import java.util.Map;

/** A singleton class may act as a repository for the purposes of this test **/
public class ItemSingleton {

    private static ItemSingleton instance = null;
    public Map<String, Item> itemMap = new HashMap<String, Item>(); // HashMap used for data persistance

    private ItemSingleton() {

    }

    /** Ensuring to have a thread-safe singleton instance **/
    public static synchronized ItemSingleton getInstance() {

        if (instance == null) {
            instance = new ItemSingleton();
        }
        return instance;
    }

}

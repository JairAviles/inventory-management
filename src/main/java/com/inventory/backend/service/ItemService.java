package com.inventory.backend.service;

import com.inventory.backend.model.Item;
import com.inventory.backend.repositories.ICommand;
import com.inventory.backend.repositories.ItemRepository;

public class ItemService {
    private static ICommand commandItem = new ItemRepository();

    public static void create(String command) {
//        Item item = new Item();
//        commandItem.create(item);
    }

    public static void updateBuy(String command) {
//        commandItem.updateBuy("", 0);
    }

    public static void updateSell(String command) {
//        commandItem.updateSell("", 0);
    }

    public static void delete(String command) {
//        commandItem.delete("");
    }

    public static void report() {
        commandItem.report();
    }

}

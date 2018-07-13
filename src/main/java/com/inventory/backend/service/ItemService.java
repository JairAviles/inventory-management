package com.inventory.backend.service;

import com.inventory.backend.model.Item;
import com.inventory.backend.repositories.ICommand;
import com.inventory.backend.repositories.ItemRepository;
import com.inventory.exceptions.ItemException;
import com.inventory.util.InventoryUtil;

public class ItemService {
    private static ICommand commandItem = new ItemRepository();

    public static void create(String command) {
        String params[] = command.split(" ");

        if (params.length == 4) {
            Double costPrice = Double.parseDouble(params[2].trim());
            Double sellPrice = Double.parseDouble(params[3].trim());

            Item item = new Item();
            item.setName(params[1].trim());
            item.setCostPrice(costPrice.longValue());
            item.setSellPrice(sellPrice.longValue());
            item.setQuantity(0);
            commandItem.create(item);
        } else {
            throw new ItemException("Invalid params for create command!");
        }
    }

    public static void updateBuy(String command) {
        String params[] = command.split(" ");
        if (params.length == 2) {
            commandItem.updateBuy(params[0], Integer.parseInt(params[1]));
        }  else {
            throw new ItemException("Invalid params for create command!");
        }
    }

    public static void updateSell(String command) {
        String params[] = command.split(" ");
        if (params.length == 2) {
            commandItem.updateSell(params[0], Integer.parseInt(params[1]));
        }  else {
            throw new ItemException("Invalid params for create command!");
        }
    }

    public static void delete(String command) {
        String params[] = command.split(" ");
        commandItem.delete(params[1]);
    }

    public static void report() {
        commandItem.report();
    }

}

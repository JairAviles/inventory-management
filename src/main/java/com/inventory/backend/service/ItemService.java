package com.inventory.backend.service;

import com.inventory.backend.model.Item;
import com.inventory.backend.repositories.ICommand;
import com.inventory.backend.repositories.ItemRepository;
import com.inventory.exceptions.ItemException;
import com.inventory.util.InventoryUtil;

public class ItemService {
    private static ICommand commandItem = new ItemRepository();

    public static void create(String command) {
        System.out.println(command);
        try {
            String params[] = command.split(" ");
            Double costPrice = Double.parseDouble(params[2].trim());
            Double sellPrice = Double.parseDouble(params[3].trim());

            boolean isParamsValid = params.length == 4
                                        && costPrice instanceof Double
                                        && sellPrice instanceof Double ? true : false;
            if (isParamsValid) {
                Item item = new Item();
                item.setName(params[1].trim());
                item.setCostPrice(costPrice.longValue());
                item.setSellPrice(sellPrice.longValue());
                item.setQuantity(0);
                commandItem.create(item);
            } else {
                throw new ItemException("Invalid params for create command!");
            }
        } catch (ItemException e) {
            InventoryUtil.logMessage(ItemRepository.class.getSimpleName(), "error", e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            InventoryUtil.logMessage(ItemRepository.class.getSimpleName(), "error", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateBuy(String command) {
//        commandItem.updateBuy("", 0);
    }

    public static void updateSell(String command) {
//        commandItem.updateSell("", 0);
    }

    public static void delete(String command) {
        String params[] = command.split(" ");
        commandItem.delete(params[1]);
    }

    public static void report() {
        commandItem.report();
    }

}

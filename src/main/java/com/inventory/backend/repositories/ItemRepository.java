package com.inventory.backend.repositories;

import com.inventory.backend.model.Item;
import com.inventory.exceptions.ItemException;

public class ItemRepository implements ICommand {

    private ItemSingleton itemSingleton = ItemSingleton.getInstance();

    public boolean create(Item item) {
        boolean res;
        if (!itemSingleton.itemMap.containsValue(item)) {
            itemSingleton.itemMap.put(item.getName(), item);
            res = true;
        } else {
            throw new ItemException(String.format("Item with name %s already registered in the inventory.\"", item.getName()));
        }
        return res;
    }

    public boolean updateBuy(String itemName, int quantity) {
        boolean res;
        if (itemSingleton.itemMap.containsKey(itemName)) {
            Item tmpItem = itemSingleton.itemMap.get(itemName);
            tmpItem.setQuantity(quantity + tmpItem.getQuantity());
            res = true;
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.\"", itemName));
        }
        return res;
    }

    public boolean updateSell(String itemName, int quantity) {
        boolean res;
        if (itemSingleton.itemMap.containsKey(itemName)) {

            res = true;
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.\"", itemName));
        }
        return res;
    }

    public boolean delete(String itemName) {
        boolean res;
        if (itemSingleton.itemMap.containsKey(itemName)) {
            itemSingleton.itemMap.remove(itemName);
            res = true;
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.\"", itemName));
        }
        return res;
    }

    public void report() {

    }
}

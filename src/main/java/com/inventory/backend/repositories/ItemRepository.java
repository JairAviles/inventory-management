package com.inventory.backend.repositories;

import com.inventory.backend.model.Item;
import com.inventory.exceptions.ItemException;

public class ItemRepository implements ICommand {

    private ItemSingleton itemSingleton = ItemSingleton.getInstance();

    public void create(Item item) {
        if (!itemSingleton.itemMap.containsValue(item)) {
            itemSingleton.itemMap.put(item.getName(), item);
        } else {
            throw new ItemException(String.format("Item with name %s already registered in the inventory.", item.getName()));
        }
    }

    public void updateBuy(String itemName, int quantity) {
        if (itemSingleton.itemMap.containsKey(itemName)) {
            Item tmpItem = itemSingleton.itemMap.get(itemName);
            tmpItem.setQuantity(quantity + tmpItem.getQuantity());
            itemSingleton.itemMap.replace(itemName, tmpItem);
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.", itemName));
        }
    }

    public void updateSell(String itemName, int quantity) {
        if (itemSingleton.itemMap.containsKey(itemName)) {
            Item tmpItem = itemSingleton.itemMap.get(itemName);

            if (tmpItem.getQuantity() > quantity) {
                tmpItem.setQuantity(quantity - tmpItem.getQuantity());
                itemSingleton.itemMap.replace(itemName, tmpItem);
            } else {
                throw new ItemException(String.format("Item with name %s doesn't have enough %d quantity for sell", itemName, quantity));
            }

        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.", itemName));
        }
    }

    public void delete(String itemName) {
        if (itemSingleton.itemMap.containsKey(itemName)) {
            itemSingleton.itemMap.remove(itemName);
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.", itemName));
        }
    }

    public void report() {

    }
}

package com.inventory.backend.repositories;

import com.inventory.backend.model.Item;
import com.inventory.exceptions.ItemException;
import com.inventory.util.InventoryUtil;

public class ItemRepository implements ICommand {

    private ItemSingleton itemSingleton = ItemSingleton.getInstance();
    private final String REPORT_TITLE = "\t\t\t INVENTORY REPORT";
    private final String ITEM_NAME_COLUMN_TITLE = "Item Name";
    private final String BOUGHT_AT_COLUMN_TITLE = "Bought At";
    private final String SOLD_AT_COLUMN_TITLE = "Sold At";
    private final String AVAILABLE_QTY_COLUMN_TITLE = "Sold At";

    public void create(Item item) {
        if (!itemSingleton.currentItemMap.containsKey(item.getName())) {
            itemSingleton.currentItemMap.put(item.getName(), item);
            InventoryUtil.logMessage(ItemRepository.class.getSimpleName(), "info", String.format("Item with name %s created with success.", item.getName()));
        } else {
            throw new ItemException(String.format("Item with name %s already registered in the inventory.", item.getName()));
        }
    }

    public void updateBuy(String itemName, int quantity) {
        if (itemSingleton.currentItemMap.containsKey(itemName)) {
            Item tmpItem = itemSingleton.currentItemMap.get(itemName);
            tmpItem.setQuantity(quantity + tmpItem.getQuantity());
            itemSingleton.currentItemMap.replace(itemName, tmpItem);
            InventoryUtil.logMessage(ItemRepository.class.getSimpleName(), "info", String.format("Item with name %s updated quantity by buy with success.", itemName));
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.", itemName));
        }
    }

    public void updateSell(String itemName, int quantity) {
        if (itemSingleton.currentItemMap.containsKey(itemName)) {
            Item tmpItem = itemSingleton.currentItemMap.get(itemName);

            if (tmpItem.getQuantity() >= quantity) {
                tmpItem.setQuantity(quantity - tmpItem.getQuantity());
                itemSingleton.currentItemMap.replace(itemName, tmpItem);
                InventoryUtil.logMessage(ItemRepository.class.getSimpleName(), "info", String.format("Item with name %s updated quantity by sell with success.", itemName));
            } else {
                throw new ItemException(String.format("Item with name %s doesn't have enough %d quantity for sell", itemName, quantity));
            }

        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.", itemName));
        }
    }

    public void delete(String itemName) {
        if (itemSingleton.currentItemMap.containsKey(itemName)) {
            itemSingleton.currentItemMap.remove(itemName);
            InventoryUtil.logMessage(ItemRepository.class.getSimpleName(), "info", String.format("Item with name %s deleted with success.", itemName));
        } else {
            throw new ItemException(String.format("Item with name %s doesn't exists in the inventory.", itemName));
        }
    }

    public void report() {
        if (itemSingleton.currentItemMap.isEmpty()) {
            throw new ItemException("No data registered in the inventory!");
        } else {
            itemSingleton.lastItemMap = itemSingleton.currentItemMap;
        }
    }
}

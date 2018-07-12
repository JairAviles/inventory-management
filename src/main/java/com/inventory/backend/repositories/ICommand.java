package com.inventory.backend.repositories;

import com.inventory.backend.model.Item;

public interface ICommand {

    boolean create(Item item);

    boolean updateBuy(String itemName, int quantity);

    boolean updateSell(String itemName, int quantity);

    boolean delete(String itemName);

    void report();

}

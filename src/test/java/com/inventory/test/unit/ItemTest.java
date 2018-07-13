package com.inventory.test.unit;

import com.inventory.backend.repositories.ItemSingleton;
import com.inventory.backend.service.ItemService;
import com.inventory.util.InventoryUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private ItemSingleton itemSingleton;

    @Before
    public void init() {
        itemSingleton = ItemSingleton.getInstance();
    }

    @Test
    public void shouldCreateNewItemSuccessfully() {
        ItemService.create("create Test01 10.0 15.0");
        ItemService.create("create Test02 8.0 13.0");
        ItemService.create("create Test03 4.0 7.0");

        Assert.assertFalse(itemSingleton.currentItemMap.isEmpty());
    }

    @Test
    public void shouldDeleteExistingItemsSuccesfully() {
        Assert.assertFalse(itemSingleton.currentItemMap.isEmpty());

        ItemService.delete("delete Test01");
        ItemService.delete("delete Test02");
        ItemService.delete("delete Test03");
        Assert.assertTrue(itemSingleton.currentItemMap.isEmpty());

    }

}

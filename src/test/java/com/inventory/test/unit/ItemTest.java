package com.inventory.test.unit;

import com.inventory.backend.repositories.ItemSingleton;
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
    public void shouldCreateNewItemSuccesfully() {
        itemSingleton.currentItemMap = InventoryUtil.createMockItems();

        Assert.assertTrue(!itemSingleton.currentItemMap.isEmpty());
    }

}

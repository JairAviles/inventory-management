package com.inventory.test.unit;

import com.inventory.backend.repositories.ItemSingleton;
import org.junit.Before;

public class ItemTest {

    private ItemSingleton itemSingleton;

    @Before
    private void init() {
        itemSingleton = ItemSingleton.getInstance();
    }

}

package com.inventory.test.unit;

import com.inventory.backend.repositories.ItemSingleton;
import com.inventory.backend.service.ItemService;
import com.inventory.exceptions.ItemException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private ItemSingleton itemSingleton;

    @Before
    public void init() {
        itemSingleton = ItemSingleton.getInstance();
        ItemService.create("create Test01 10.0 15.0");
        ItemService.create("create Test02 8.0 13.0");
        ItemService.create("create Test03 4.0 7.0");
    }

    @After
    public void finish() {
        ItemService.delete("delete Test01");
        ItemService.delete("delete Test02");
        ItemService.delete("delete Test03");
    }

    @Test(expected = ItemException.class)
    public void shouldThrownItemExceptionWhenCreateNewItemHasWrongParams() {
        ItemService.create("create Test01 20.0 22.5");
    }

    @Test(expected = ItemException.class)
    public void shouldThrownItemExceptionWhenCreateNewItemHasExistingItem() {
        ItemService.create("create WrongParamsPassed");
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrownNumberFormatExceptionWhenCreateNewItemHasWrongParams() {
        ItemService.create("create Wrong Params Passed");
    }

    @Test
    public void shouldUpdateBuySuccessfully() {
        ItemService.updateBuy("updateBuy Test01 10");

        Assert.assertEquals(10, itemSingleton.currentItemMap.get("Test01").getQuantity());
    }

    @Test(expected = ItemException.class)
    public void shouldThrownItemExceptionWhenUpdateBuyPassesNoExistingItem() {
        ItemService.updateBuy("updateBuy WrongParamsPassed");
    }

    @Test
    public void shouldUpdateSellSuccessfully() {
        ItemService.updateBuy("updateBuy Test01 10");

        Assert.assertEquals(10, itemSingleton.currentItemMap.get("Test01").getQuantity());

        ItemService.updateSell("updateSell Test01 10");

        Assert.assertEquals(0, itemSingleton.currentItemMap.get("Test01").getQuantity());
    }

    @Test(expected = ItemException.class)
    public void shouldThrownItemExceptionWhenUpdateSellPassesNoExistingItem() {
        ItemService.updateSell("updateSell WrongParamsPassed");
    }


}

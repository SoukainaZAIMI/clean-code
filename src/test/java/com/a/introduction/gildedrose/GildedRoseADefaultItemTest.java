package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemTest {

	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int UNEXPIRED_SELLIN = 15;
	public static final int QUALITY = 3;
	public static final int EXPIRED_SELLIN = -1;

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 1 when the item is not expired
	 * and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void testUpdateQualityDefault1() {
        GildedRose app = createGildedRoseApp(DEFAULT_ITEM, UNEXPIRED_SELLIN, QUALITY);
		Item expectedItem = new Item(DEFAULT_ITEM, UNEXPIRED_SELLIN - 1, QUALITY - 1);
		assertItems(expectedItem, app.items[0]);
	}

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 *
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 *
	 */
	@Test
	public void testUpdateQualityForExpiredItem() {
		GildedRose app = createGildedRoseApp(DEFAULT_ITEM,EXPIRED_SELLIN, QUALITY);
		Item expectedItem = new Item(DEFAULT_ITEM, EXPIRED_SELLIN - 1, QUALITY - 2);
		assertItems(expectedItem, app.items[0]);
	}

	private static void assertItems(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private static GildedRose createGildedRoseApp(String defaultItem, int sellin, int quality) {
		Item item = new Item(defaultItem, sellin, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app;
	}
}
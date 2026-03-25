package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseBAgedBrieTest {

	private static final String AGED_BRIE = "Aged Brie";
	private static final int INITIAL_SELLIN = 4;
	private static final int INITIAL_QUALITY = 3;
	private static final int MAX_QUALITY = 50;
	private static final int EXPIRED_SELLIN = -1;

	@Test
	public void testUpdateQualityAgedBrie1() {
		GildedRose app = createGildedRoseApp(AGED_BRIE, INITIAL_SELLIN, INITIAL_QUALITY);
		Item expectedItem = new Item(AGED_BRIE, INITIAL_SELLIN - 1, INITIAL_QUALITY + 1);
		assertItems(app.items[0], expectedItem);
	}

	@Test
	public void testUpdateQualityAgedBrie2() {
		GildedRose app = createGildedRoseApp(AGED_BRIE, EXPIRED_SELLIN, INITIAL_QUALITY);
		Item expectedItem = new Item(AGED_BRIE, EXPIRED_SELLIN - 1, INITIAL_QUALITY + 2);
		assertItems(app.items[0], expectedItem);
	}

	@Test
	public void testUpdateQualityAgedBrie3() {
		GildedRose app = createGildedRoseApp(AGED_BRIE, INITIAL_SELLIN, MAX_QUALITY);
		Item expectedItem = new Item(AGED_BRIE, INITIAL_SELLIN - 1, MAX_QUALITY);
		assertItems(app.items[0], expectedItem);
	}

	private GildedRose createGildedRoseApp(String name, int sellIn, int quality) {
		Item item = new Item(name, sellIn, quality);
		GildedRose app = new GildedRose(new Item[] { item });
		app.updateQuality();
		return app;
	}

	private static void assertItems(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}
}

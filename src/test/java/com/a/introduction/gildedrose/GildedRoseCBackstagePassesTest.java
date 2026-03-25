package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseCBackstagePassesTest {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final int INITIAL_SELLIN_1 = 15;
    private static final int INITIAL_SELLIN_2 = 7;
    private static final int INITIAL_SELLIN_3 = 4;
    private static final int INITIAL_QUALITY = 3;
    private static final int EXPECTED_QUALITY_1 = 4;
    private static final int EXPECTED_QUALITY_2 = 5;
    private static final int EXPECTED_QUALITY_3 = 6;

    @Test
    public void testUpdateQualityBackstagePasses1() {
        GildedRose app = createGildedRoseApp(BACKSTAGE_PASSES, INITIAL_SELLIN_1, INITIAL_QUALITY);
        assertItem(app.items[0], BACKSTAGE_PASSES, INITIAL_SELLIN_1 - 1, EXPECTED_QUALITY_1);
    }

    @Test
    public void testUpdateQualityBackstagePasses2() {
        GildedRose app = createGildedRoseApp(BACKSTAGE_PASSES, INITIAL_SELLIN_2, INITIAL_QUALITY);
        assertItem(app.items[0], BACKSTAGE_PASSES, INITIAL_SELLIN_2 - 1, EXPECTED_QUALITY_2);
    }

    @Test
    public void testUpdateQualityBackstagePasses3() {
        GildedRose app = createGildedRoseApp(BACKSTAGE_PASSES, INITIAL_SELLIN_3, INITIAL_QUALITY);
        assertItem(app.items[0], BACKSTAGE_PASSES, INITIAL_SELLIN_3 - 1, EXPECTED_QUALITY_3);
    }

    private GildedRose createGildedRoseApp(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        return app;
    }

    private void assertItem(Item actual, String expectedName, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedName, actual.name);
        assertEquals(expectedSellIn, actual.sellIn);
        assertEquals(expectedQuality, actual.quality);
    }
}
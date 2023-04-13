package org.kata.market.pricing;

import org.junit.Test;
import org.kata.market.model.Item;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultPricingTest {
    @Test
    public void should_calculate_price() {
        Item anItem = new Item(true, null, "bean can", 11);
        DefaultPricing defaultPricing = new DefaultPricing();
        int valueToBuy = 4;

        defaultPricing.calculatePrice(anItem, valueToBuy);

        assertThat(defaultPricing.calculatePrice(anItem, valueToBuy), is(44f));
    }
}
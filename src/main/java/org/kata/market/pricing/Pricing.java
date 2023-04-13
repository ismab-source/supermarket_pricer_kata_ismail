package org.kata.market.pricing;

import org.kata.market.model.Item;

public interface Pricing {

     float calculatePrice(Item item, float numberBought);

}

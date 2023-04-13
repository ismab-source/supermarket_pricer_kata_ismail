package org.kata.market.pricing;

import lombok.Data;
import org.kata.market.model.Item;

@Data
public class DefaultPricing implements Pricing{
    @Override
    public float calculatePrice(Item item, float numberBought) {
        return (item.getUnitaryPrice() * numberBought);
    }
}

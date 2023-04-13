package org.kata.market.pricing;

import lombok.Data;
import org.kata.market.model.Item;

@Data

public class PackagePricing implements Pricing{
    @Override
    public float calculatePrice(Item item, float numberBought) {
        int numberForReduction = item.getReductionValueByNumber()._1();
        int timesReductionApplied = (int) (numberBought / numberForReduction);
        float numberOfFullPriceGoods = numberBought % numberForReduction;
        float reductionValue = item.getReductionValueByNumber()._2();
        float reducedPrice = timesReductionApplied * item.getUnitaryPrice() * numberForReduction * reductionValue;
        float unreducedPrice = numberOfFullPriceGoods * item.getUnitaryPrice();
        return reducedPrice + unreducedPrice;
    }
}

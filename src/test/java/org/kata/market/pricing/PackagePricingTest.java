package org.kata.market.pricing;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kata.market.model.Item;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PackagePricingTest {
    @Test
    @Parameters({"2f, 100f",
            "3f, 150f",
            "4f, 160f",
            "6f, 260f"})
    public void should_apply_reduction_when_package_number_needed_reached(float inputNumberToBuy, float expectedPrice) {
        Tuple2<Integer, Float> inputReduction = Tuple.of(4, 0.8f);
        Item anItem = new Item(true, inputReduction, "item", 50);
        PackagePricing packagePricing = new PackagePricing();

        packagePricing.calculatePrice(anItem, inputNumberToBuy);

        assertThat(packagePricing.calculatePrice(anItem, inputNumberToBuy), is(expectedPrice));
    }
}

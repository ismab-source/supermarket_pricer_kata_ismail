package org.kata.market.model;


import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupermarketTest {

    private Supermarket supermarket;
    private Customer customer;


    @Test
    public void item_should_correctly_be_updated_when_reduction_set() {
        supermarket = new Supermarket();
        Item anItem = new Item(false, null, "", 50);
        supermarket.addReduction(anItem, 2, 0.5f);

        assertThat(anItem.getReductionValueByNumber()._1(), is(2));
        assertThat(anItem.getReductionValueByNumber()._2(), is(0.5f));
    }

    @Test
    public void item_reduction_should_correctly_be_replaced_when_new_reduction_set() {
        supermarket = new Supermarket();
        Item anItem = new Item(false, null, "bean can", 50);
        supermarket.addReduction(anItem, 10, 0.9f);

        supermarket.addReduction(anItem, 2, 0.5f);

        assertThat(anItem.getReductionValueByNumber()._1(), is(2));
        assertThat(anItem.getReductionValueByNumber()._2(), is(0.5f));
    }


    @Test
    public void item_should_correctly_be_updated_when_reduction_removed() {
        supermarket = new Supermarket();
        Tuple2<Integer, Float> inputReduction = Tuple.of(2, 0.5f);
        Item anItem = new Item(false, inputReduction, "bean can", 50);

        supermarket.removeReductions(anItem);

        assertThat(anItem.getReductionValueByNumber()._1(), is(nullValue()));
    }

    @Test
    public void price_should_be_correct_when_calculating_bill() {
        supermarket = new Supermarket();
        customer = new Customer();
        Item bean_can = new Item(false, null, "bean can", 50);
        Item water_bottle = new Item(true, null, "water bottle", 5);
        Item pasta_pack = new Item(false, null, "pasta pack", 10);
        customer.addToCart(bean_can, 4);
        customer.addToCart(water_bottle, 2.2f);
        customer.addToCart(pasta_pack, 3);
        supermarket.addReduction(pasta_pack, 2, 0.5f);

        supermarket.calculateBill(customer);
        assertThat(supermarket.calculateBill(customer), is(231.0f));
    }

}


package org.kata.market.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {
    private Item bean_can, water_bottle;
    private Customer customer;

    @Test
    public void should_add_to_cart() {
        customer = new Customer();
        bean_can = new Item(false, null, "bean can", 50);
        water_bottle = new Item(true, null, "water bottle", 5);

        customer.addToCart(bean_can, 1f);
        customer.addToCart(water_bottle, 1.2f);

        assertThat(customer.getCart().toString(), is("{" + bean_can.toString() + "=1.0, " + water_bottle.toString() + "=1.2}"));
    }

    @Test
    public void should_update_value_in_cart() {
        customer = new Customer();
        bean_can = new Item(false, null, "bean can", 50);
        water_bottle = new Item(true, null, "water bottle", 5);

        customer.addToCart(bean_can, 1f);
        customer.addToCart(water_bottle, 1.2f);
        customer.addToCart(bean_can, 1f);

        assertThat(customer.getCart().toString(), is("{" + bean_can.toString() + "=2.0, " + water_bottle.toString() + "=1.2}"));
    }

    @Test
    public void should_remove_from_cart() {
        customer = new Customer();
        bean_can = new Item(false, null, "bean can", 50);
        water_bottle = new Item(true, null, "water bottle", 5);
        customer.addToCart(water_bottle, 1.7f);
        customer.addToCart(bean_can, 2.0f);

        customer.removeFromCart(bean_can, 2.0f);
        customer.removeFromCart(water_bottle, 1.2f);

        assertThat(customer.getCart().toString(), is("{" + water_bottle.toString() + "=0.5}"));
    }
}

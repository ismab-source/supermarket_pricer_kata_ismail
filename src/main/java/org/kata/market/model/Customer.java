package org.kata.market.model;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.vavr.API.*;

@Data
class Customer {
    private LinkedHashMap<Item, Float> cart = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger( Customer.class.getPackage().getName() );

    void addToCart(Item item, float numberToBuy) {
        if (cart.containsKey(item)) {
            if(item.isByWeight() && (numberToBuy - (int) numberToBuy) != 0)
            {
                logger.log(Level.INFO," Error : you cannot buy half an item !");
            }
            else
            {
                cart.put(item, numberToBuy + cart.get(item));
            }
        }
        else
        {
            cart.put(item, numberToBuy);
        }
    }

    void removeFromCart(Item item, float number) {
        if (cart.containsKey(item))
        {
            Match(cart.get(item) - number).of(
                    Case($(n -> n > 0), () -> cart.replace(item, cart.get(item) - number)),
                    Case($(), () -> cart.remove(item)));
        }
    }

}
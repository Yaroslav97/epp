package com.epam.poliakov.task9.shop.controller.CommandImpl;

import com.epam.poliakov.task9.shop.controller.Command;
import com.epam.poliakov.task9.shop.controller.constant.TitleConst;
import com.epam.poliakov.task9.shop.repository.cart.LastProductsInCart;

import java.util.Map;

public class TopLastProductsCommand implements Command {
    private LastProductsInCart lastProductsInCart;

    public TopLastProductsCommand(LastProductsInCart lastProductsInCart) {
        this.lastProductsInCart = lastProductsInCart;
    }

    @Override
    public void execute() {
        if (!lastProductsInCart.isEmpty()) {
            System.out.println(TitleConst.LAST_PRODUCT_IN_CART);

            for (Map.Entry entry : lastProductsInCart.getTopLastCart().entrySet()) {
                System.out.println(entry.getValue() + "}");
            }
        } else {
            System.out.println("list of top last products is empty");
        }
    }
}

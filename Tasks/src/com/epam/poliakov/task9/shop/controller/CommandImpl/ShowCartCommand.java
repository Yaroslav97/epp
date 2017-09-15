package com.epam.poliakov.task9.shop.controller.CommandImpl;

import com.epam.poliakov.task9.shop.controller.Command;
import com.epam.poliakov.task9.shop.controller.constant.TitleConst;
import com.epam.poliakov.task9.shop.service.CartService;

import java.util.Map;

import static com.epam.poliakov.task4.controller.constant.CommandConst.ADD_TO_CART;

public class ShowCartCommand implements Command {

    private CartService cartService;

    public ShowCartCommand(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        if (!cartService.isEmpty()) {
            System.out.println(TitleConst.CART);
            for (Map.Entry entry : cartService.getCartMap().entrySet()) {
                System.out.println(entry.getKey() + " countOfProduct = " + entry.getValue() + "}");
            }
        } else {
            System.out.printf("cart is empty\nadd some productEntity in cart with command - %s", ADD_TO_CART);
        }
    }
}

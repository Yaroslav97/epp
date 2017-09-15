package com.epam.poliakov.task4.controller.CommandImpl;

import com.epam.poliakov.task4.controller.Command;
import com.epam.poliakov.task4.controller.constant.TitleConst;
import com.epam.poliakov.task4.service.CartService;

public class TotalPriceCommand implements Command {
    private CartService cartService;

    public TotalPriceCommand(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        if (!cartService.isEmpty()) {
            System.out.println(TitleConst.TOTAL_PRICE);
            System.out.println(cartService.getPriceOfProductsInCart());
        } else {
            System.out.println("cart is empty");
        }
    }
}

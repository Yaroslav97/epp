package com.epam.poliakov.task7_1.shop.controller.CommandImpl;

import com.epam.poliakov.task7_1.shop.controller.Command;
import com.epam.poliakov.task7_1.shop.service.CartService;
import com.epam.poliakov.task7_1.shop.service.StoreService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddProductToCartCommand implements Command {
    private CartService cartService;
    private StoreService storeService;
    private Scanner scanner;

    public AddProductToCartCommand(CartService cartService, StoreService storeService, Scanner scanner) {
        this.cartService = cartService;
        this.storeService = storeService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {

        System.out.println("Enter productName $");
        String product = scanner.nextLine();

        System.out.println("Enter countOfProduct $");
        int countOfProduct = 0;

        try {
            countOfProduct = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("incorrect value");
        }

        if (storeService.isExist(product) && countOfProduct > 0) {
            cartService.addProductToCart(storeService.getProduct(product), countOfProduct);
            System.out.printf("productEntity %s [%d] added", product, countOfProduct);
        } else {
            System.err.printf("the productEntity %s is not exist", product);
        }
    }
}

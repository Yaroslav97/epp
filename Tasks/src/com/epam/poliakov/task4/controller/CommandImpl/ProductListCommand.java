package com.epam.poliakov.task4.controller.CommandImpl;

import com.epam.poliakov.task4.controller.constant.TitleConst;
import com.epam.poliakov.task4.controller.Command;
import com.epam.poliakov.task4.entity.Product;
import com.epam.poliakov.task4.service.StoreService;

import java.util.Map;

public class ProductListCommand implements Command {

    private StoreService storeService;

    public ProductListCommand(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public void execute() {
        System.out.println(TitleConst.PRODUCT_SHOP);
        for (Map.Entry<String, Product> entry : storeService.getProductMap().getStore().entrySet()) {
            System.out.println(entry.getValue() + "}");
        }
    }
}

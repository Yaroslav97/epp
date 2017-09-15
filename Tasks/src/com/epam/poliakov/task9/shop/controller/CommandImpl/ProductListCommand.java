package com.epam.poliakov.task9.shop.controller.CommandImpl;

import com.epam.poliakov.task9.shop.controller.Command;
import com.epam.poliakov.task9.shop.controller.constant.TitleConst;
import com.epam.poliakov.task9.shop.entity.productEntity.Vehicle;
import com.epam.poliakov.task9.shop.service.StoreService;

import java.util.Map;

public class ProductListCommand implements Command {

    private StoreService storeService;

    public ProductListCommand(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public void execute() {
        System.out.println(TitleConst.PRODUCT_SHOP);
        for (Map.Entry<String, Vehicle> entry : storeService.getProductMap().getStore().entrySet()) {
            System.out.println(entry.getValue() + "}");
        }
    }
}

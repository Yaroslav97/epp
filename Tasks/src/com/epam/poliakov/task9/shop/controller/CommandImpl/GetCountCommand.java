package com.epam.poliakov.task9.shop.controller.CommandImpl;

import com.epam.poliakov.task9.shop.controller.Command;
import com.epam.poliakov.task9.shop.service.StoreService;

public class GetCountCommand implements Command {
    private StoreService storeService;

    public GetCountCommand(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public void execute() {

        System.out.println("Count of products in store: " + storeService.getProductMap().getStore().size());
    }
}

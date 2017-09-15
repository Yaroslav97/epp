package com.epam.poliakov.task9.web.command.command;

import com.epam.poliakov.task9.web.command.WebCommand;
import com.epam.poliakov.task9.shop.service.StoreService;

public class GetItemCommand implements WebCommand {

    private StoreService storeService;

    public GetItemCommand(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public String execute(String req) {

        return storeService.getProduct(req).getName() + " | " +
                storeService.getProduct(req).getPrice();
    }
}

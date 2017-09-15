package com.epam.poliakov.task9.web.command.command;

import com.epam.poliakov.task9.shop.service.StoreService;
import com.epam.poliakov.task9.web.command.WebCommand;

public class GetItemGetQuery implements WebCommand {

    private StoreService storeService;

    public GetItemGetQuery(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public String execute(String req) {

        if (storeService.isExist(req)) {
            return "{name: " + storeService.getProduct(req).getName() + ", price: " +
                    storeService.getProduct(req).getPrice() + "}";
        } else if (req.equals("")){
            return "{}";
        }
        else {
            return "{}";
        }
    }
}

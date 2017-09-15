package com.epam.poliakov.task9.web.command.command;

import com.epam.poliakov.task9.shop.service.StoreService;
import com.epam.poliakov.task9.web.command.WebCommand;

public class GetCountGetQuery implements WebCommand {

    private StoreService storeService;

    public GetCountGetQuery(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public String execute(String command) {
        return "{count: " + storeService.getProductMap().getStore().size() + "}";
    }
}

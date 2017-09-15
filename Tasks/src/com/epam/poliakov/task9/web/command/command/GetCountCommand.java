package com.epam.poliakov.task9.web.command.command;

import com.epam.poliakov.task9.web.command.WebCommand;
import com.epam.poliakov.task9.shop.service.StoreService;

public class GetCountCommand implements WebCommand {

    private StoreService storeService;

    public GetCountCommand(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public String execute(String command) {
        return String.valueOf(storeService.getProductMap().getStore().size());
    }
}

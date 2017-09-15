package com.epam.poliakov.task9.web.command;

import com.epam.poliakov.task9.web.command.command.GetCountCommand;
import com.epam.poliakov.task9.shop.service.StoreService;
import com.epam.poliakov.task9.web.command.command.GetCountGetQuery;
import com.epam.poliakov.task9.web.command.command.GetItemCommand;
import com.epam.poliakov.task9.web.command.command.GetItemGetQuery;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.poliakov.task9.web.command.command.WEBCommandCons.*;

public class WebCommandManager implements WebCommand {

    private HashMap<String, WebCommand> commandMap;

    public WebCommandManager(StoreService storeService) {

        commandMap = new HashMap();
        commandMap.put(GET_COUNT, new GetCountCommand(storeService));
        commandMap.put(GET_ITEM, new GetItemCommand(storeService));
        commandMap.put(HTTP_GET_COUNT, new GetCountGetQuery(storeService));
        commandMap.put(HTTP_GET_ITEM, new GetItemGetQuery(storeService));
    }

    @Override
    public String execute(String req) {

        String[] reqWithEquals = req.split("=");
        String[] reqWithEquelsHttp = parseGetQuery(req).split("=");

        if (commandMap.containsKey(req)) {
            return commandMap.get(req)
                    .execute(req);
        } else if (commandMap.containsKey(reqWithEquals[0])) {
            return commandMap.get(reqWithEquals[0].trim())
                    .execute(reqWithEquals[1].trim());
        } else if (commandMap.containsKey(parseGetQuery(req))) {
            return commandMap.get(parseGetQuery(req))
                    .execute(parseGetQuery(req));
        } else if (commandMap.containsKey(reqWithEquelsHttp[0].trim())) {
            return commandMap.get(reqWithEquelsHttp[0].trim())
                    .execute(reqWithEquelsHttp[1].trim());
        } else {
            return "wrong command";
        }
    }

    private String parseGetQuery(String req) {

        Pattern pattern = Pattern.compile("(/[a-z/?_= a-z]+)");
        Matcher matcher = pattern.matcher(req);

        if (matcher.find()) {
            return matcher.group().trim();
        }
        return req;
    }
}

package com.epam.poliakov.task4.controller.CommandImpl;

import com.epam.poliakov.task4.controller.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("exit from store");
        System.exit(0);
    }
}

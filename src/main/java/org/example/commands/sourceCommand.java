package org.example.commands;

import java.util.List;

public class sourceCommand extends Commands {
    public sourceCommand(List<String> arg) {
        super("/",arg);
    }

    @Override
    public String execute(Computer target) {
        return null;
    }
}

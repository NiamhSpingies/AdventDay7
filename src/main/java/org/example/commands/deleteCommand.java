package org.example.commands;

import java.util.List;

public class deleteCommand extends Commands {
    public deleteCommand(List<String> arg) {
        super("delete",arg);
    }

    @Override
    public String execute(Computer target) {
        return null;
    }
}

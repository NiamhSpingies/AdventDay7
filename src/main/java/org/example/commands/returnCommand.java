package org.example.commands;

import java.util.List;

public class returnCommand extends Commands {
    public returnCommand(List<String> arg) {
        super("..",arg);
    }

    @Override
    public String execute(Computer target) {
        return null;
    }
}

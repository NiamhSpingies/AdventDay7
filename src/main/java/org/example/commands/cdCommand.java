package org.example.commands;

import java.util.List;

public class cdCommand extends Commands {
    public cdCommand(List<String> arg) {
        super("cd", arg);
    }

    @Override
    public String execute(Computer target) {
        return null;
    }
}

package org.example.commands;

import java.util.List;

public class lsCommand extends Commands {
    public lsCommand(List<String> arg) {
        super("ls",arg);
    }

    @Override
    public String execute(Computer target) {
        return null;
    }
}

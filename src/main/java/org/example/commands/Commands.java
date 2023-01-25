package org.example.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Commands {
        private final String name;
        private List<String> arg;

        public abstract String execute(Computer target);

        /**
         * Instantiates a new Command.
         *
         * @param name the name
         */
        public Commands(String name) {
            this(name, new ArrayList<>());
        }

        /**
         * Instantiates a new Command.
         *
         * @param name the name
         * @param arg  the arg
         */
        public Commands(String name, List<String> arg) {
            this.name = name.trim().toLowerCase();
            this.arg = arg;
        }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return this.name;
        }

        /**
         * Gets arg.
         *
         * @return the arg
         */
        public List<String> getArg() {
            return this.arg;
        }

        /**
         * Create command.
         *
         * @param command the command
         * @param arg     the arg
         * @return the command
         */
        public static Commands create(String command, List<String> arg) {
            switch (command.toLowerCase()) {
                case "ls":
                    return new lsCommand(arg);
                case "..":
                    return new returnCommand(arg);
                case "cd":
                    return new cdCommand(arg);
                case "/":
                    return new sourceCommand(arg);
                case "delete":
                    return new deleteCommand(arg);
                default:
                    return null;
            }
        }

}

package ua.goit.view;

public interface Command {

    void process();

    String commandName();

    default boolean canProcess(String command) {
        return this.commandName().equals(command);
    }

}
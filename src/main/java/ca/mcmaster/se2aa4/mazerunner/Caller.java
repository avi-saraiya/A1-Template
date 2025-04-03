package ca.mcmaster.se2aa4.mazerunner;

public class Caller {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        if (command != null) {
            command.execute();
        }
    }
}
package App.Commands;

import App.Controller;

public class OpenSaveMenuCommand implements Command {
    Controller controller;

    public OpenSaveMenuCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.openSaveMenu();
    }
}

package App.Commands;

import App.Controller;

public class OpenAddMenuCommand implements Command {
    Controller controller;

    public OpenAddMenuCommand(Controller controller) {
        this.controller = controller;
    }
    

    @Override
    public void execute() {
        controller.openAddMenu();
    }
}

package App.Commands;

import App.Controller;

public class CancelCommand implements Command {
    private Controller controller;

    public CancelCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.cancel();
    }
}

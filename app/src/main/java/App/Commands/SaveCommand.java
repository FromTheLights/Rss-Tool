package App.Commands;

import App.Controller;
import App.view.SaveView;

public class SaveCommand implements Command {
    private Controller controller;
    private SaveView saveView;

    public SaveCommand(Controller controller, SaveView saveView) {
        this.controller = controller;
        this.saveView = saveView;
    }

    @Override
    public void execute() {
        controller.save(saveView.getPath(), saveView.getName());
    }
}

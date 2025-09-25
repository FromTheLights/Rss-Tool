package App.Commands;

import App.Controller;
import App.view.styles.MyTextArea;

public class OpenFeedCommand implements Command
{
    Controller controller;
    MyTextArea textArea;

    public OpenFeedCommand(Controller controller, MyTextArea textArea) {
        this.controller = controller;
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        controller.openFeed(textArea.getText());
    }
}

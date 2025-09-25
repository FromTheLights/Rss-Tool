package App.Commands;

import App.RssEventModel;
import App.Controller;

public class RemoveCommand implements Command {
    private Controller controller;
    private RssEventModel rssEvent;


    public RemoveCommand(Controller controller, RssEventModel rssEvent) {
        this.controller = controller;
        this.rssEvent = rssEvent;
    }

    @Override
    public void execute() {
        controller.remove(rssEvent);
    }
}

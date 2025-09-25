package App.Commands;

import App.Controller;

import App.RssEventModel;

public class OpenRemoveMenuCommand implements Command {
    Controller controller;
    RssEventModel rssEvent;

    public OpenRemoveMenuCommand(Controller controller, RssEventModel rssEvent) {
        this.controller = controller;
        this.rssEvent = rssEvent;
    }

    @Override
    public void execute() {
        controller.openRemoveMenu(rssEvent);
    }
}

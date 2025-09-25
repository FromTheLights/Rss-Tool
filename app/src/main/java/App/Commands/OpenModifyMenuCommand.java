package App.Commands;

import App.Controller;

import App.RssEventModel;

public class OpenModifyMenuCommand implements Command {
    Controller controller;
    RssEventModel rssEvent;

    public OpenModifyMenuCommand(Controller controller, RssEventModel rssEvent) {
        this.controller = controller;
        this.rssEvent = rssEvent;
    }

    @Override
    public void execute() {
        controller.openModifyMenu(rssEvent);
    }
}

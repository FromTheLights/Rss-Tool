package App.Commands;

import App.RssEventModel;
import App.Controller;
import App.view.ModifyView;

public class ModifyCommand implements Command {
    private Controller controller;
    private RssEventModel rssEvent;
    private ModifyView modifyView;

    public ModifyCommand(Controller controller, RssEventModel rssEvent, ModifyView modifyView) {
        this.controller = controller;
        this.rssEvent = rssEvent;
        this.modifyView = modifyView;
    }

    @Override
    public void execute() {
        String title = modifyView.getTitle();
        String link = modifyView.getLink();
        String guid = modifyView.getGuid();
        String date = modifyView.getDate();
        String description = modifyView.getDescription();
        controller.modify(rssEvent, title, link, guid, date, description);
    }
}

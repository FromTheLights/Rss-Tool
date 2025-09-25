package App.Commands;

import App.Controller;
import App.view.AddView;
public class AddCommand implements Command {
    private Controller controller;
    private AddView addView;

    public AddCommand(Controller controller, AddView addView) {
        this.controller = controller;
        this.addView = addView;
    }

    @Override
    public void execute() {
        String title = addView.getTitle();
        String link = addView.getLink();
        String guid = addView.getGuid();
        String date = addView.getDate();
        String description = addView.getDescription();
        controller.add(title, link, guid, date, description);
    }
}

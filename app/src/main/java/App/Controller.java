package App;


import App.view.*;

public class Controller {
    MainFrame frame;

    public Controller() {
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public void openSaveMenu() {
        frame.UpdateUI(new SaveView(this));
    }

    public void openAddMenu() {
        frame.UpdateUI(new AddView(this));
    }

    public void openModifyMenu(RssEventModel rssEvent) {
        frame.UpdateUI(new ModifyView(this, rssEvent));
    }

    public void openRemoveMenu(RssEventModel rssEvent) {
        frame.UpdateUI(new RemoveView(this, rssEvent));
    }

    public void cancel() {
        frame.UpdateUI(new ConsultationView(this));
    }

    public void modify(RssEventModel rssEvent, String title, String link, String guid, String date,
            String description) {
        rssEvent.modify(title, link, guid, date, description);
    }

    public void save(String path, String name) {
        RssEventModel.Save(path, name);
        frame.UpdateUI(new ConsultationView(this));
    }

    public void remove(RssEventModel rssEvent) {
        rssEvent.remove();
        frame.UpdateUI(new ConsultationView(this));
    }

    public void add(String title, String link, String guid, String date, String description) {
        RssEventModel.Add(title, link, guid, date, description);
    }
}

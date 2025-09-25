package App;

import App.view.MainFrame;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MainFrame frame = new MainFrame(controller);
        controller.setFrame(frame);
        frame.setVisible(true);
    }
}


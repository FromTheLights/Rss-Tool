package App.view;

import java.awt.GridBagLayout;
import App.Controller;

import javax.swing.JPanel;

//exemple de template
public abstract class PanelTemplate extends JPanel {
    Controller controller;

    public PanelTemplate(Controller controller) {
        super();
        this.controller = controller;
    }

    public void draw() {
        prepareLayout();
        prepareContent();
    }

    public void prepareLayout() {
        this.setLayout(new GridBagLayout());
    }

    public abstract void prepareContent();
}

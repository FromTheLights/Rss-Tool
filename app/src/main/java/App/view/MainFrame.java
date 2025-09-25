package App.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import App.Controller;
import App.RssEventListener;
import App.RssEventModel;

public class MainFrame extends JFrame implements RssEventListener {
    Controller controller;
    
    public MainFrame(Controller controller) {
        super();
        this.controller = controller;
        RssEventModel.addListener(this);
        this.setTitle("Outil de manipulation du fil Rss de l'université");
        this.setMinimumSize(new Dimension(1500, 1000));
        this.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelTemplate feedChooserView = new FeedChooserView(controller);

        feedChooserView.draw();
        feedChooserView
                .setPreferredSize(new Dimension((int) (this.getHeight() * 0.85), (int) (this.getWidth() * 0.85)));
        this.add(feedChooserView);
    }

    public void UpdateUI(PanelTemplate view) {
        this.getContentPane().removeAll();
        if (!(view instanceof ConsultationView)) {
            view.setPreferredSize(new Dimension(500, 800));
        }
        view.draw();
        this.add(view);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    @Override
    public void onChange() {
        UpdateUI(new ConsultationView(controller));
    }
}

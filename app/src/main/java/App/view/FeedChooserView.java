package App.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import App.Controller;
import App.Commands.OpenFeedCommand;
import App.view.styles.IconLoader;
import App.view.styles.MyTextArea;

public class FeedChooserView extends PanelTemplate {
    MyTextArea url;
    MyTextArea name;

    public FeedChooserView(Controller controller) {
        super(controller);
    }

    @Override
    public void prepareContent() {
        url = new MyTextArea("https://www.cbc.ca/webfeed/rss/rss-world");
        GridBagConstraints gbc = new GridBagConstraints();

        
        this.setPreferredSize(new Dimension(500, 100));

        // Headers
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        this.add(new JLabel("Chemin : "), gbc);

        // Text Areas
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(url, gbc);
 

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 0;
        this.add(new MyButton(IconLoader.loadIcon("checkmark.png"), new OpenFeedCommand(controller, url)), gbc);
    }
}
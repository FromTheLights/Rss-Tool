package App.view;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.BorderFactory;

import App.Controller;
import App.Commands.AddCommand;
import App.Commands.CancelCommand;
import App.view.styles.IconLoader;
import App.view.styles.MyTextArea;

public class AddView extends PanelTemplate {
    MyTextArea title;
    MyTextArea link;
    MyTextArea guid;
    MyTextArea date;
    MyTextArea description;

    public AddView(Controller controller) {
        super(controller);
        title = new MyTextArea();
        link = new MyTextArea();
        guid = new MyTextArea();
        date = new MyTextArea();
        description = new MyTextArea();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLink() {
        return link.getText();
    }

    public String getGuid() {
        return guid.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    @Override
    public void prepareContent() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // DEBUG
        // Headers
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(new JLabel("Titre :"), gbc);
        gbc.gridy = 1;
        this.add(new JLabel("Lien :"), gbc);
        gbc.gridy = 2;
        this.add(new JLabel("Guide :"), gbc);
        gbc.gridy = 3;
        this.add(new JLabel("Date de publication :"), gbc);
        gbc.gridy = 4;
        this.add(new JLabel("Description :"), gbc);


        // Rss info
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        this.add(title, gbc);
        gbc.gridy = 1;
        this.add(link, gbc);
        gbc.gridy = 2;
        this.add(guid, gbc);
        gbc.gridy = 3;
        this.add(date, gbc);
        gbc.gridy = 4;
        this.add(description, gbc);

        
        // Buttons
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        this.add(new MyButton(IconLoader.loadIcon("checkmark.png"), new AddCommand(controller, this)),
                gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.weightx = 1;
        this.add(new MyButton(IconLoader.loadIcon("x.png"), new CancelCommand(controller)), gbc);
    }   
}

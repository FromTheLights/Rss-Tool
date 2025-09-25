package App.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import App.Controller;
import App.RssEventModel;
import App.Commands.OpenModifyMenuCommand;
import App.Commands.OpenRemoveMenuCommand;
import App.view.styles.IconLoader;

public class EventPanel extends PanelTemplate {
    RssEventModel rssEvent;

    public EventPanel(Controller controller, RssEventModel rssEvent) {
        super(controller);
        this.rssEvent = rssEvent;
    }

    @Override
    public void prepareContent() {

        setMinimumSize(new Dimension(1200, 100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Headers
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        this.add(new JLabel("Titre: "), gbc);
        gbc.gridy++;
        this.add(new JLabel("Link: "), gbc);
        gbc.gridy++;
        this.add(new JLabel("guid: "), gbc);
        gbc.gridy++;
        this.add(new JLabel("date: "), gbc);
        gbc.gridy++;
        this.add(new JLabel("Description: "), gbc);

        // Info
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 2;
        gbc.weighty = 1;


        this.add(new JLabel("<html><div style = 'width: 1000px;'>" + rssEvent.getTitle() + "</div></html>"), gbc);
        gbc.gridy++;
        this.add(new JLabel("<html><div style = 'width: 1000px;'>" + rssEvent.getLink() + "</div></html>"), gbc);
        gbc.gridy++;
        this.add(new JLabel("<html><div style = 'width: 1000px;'>" + rssEvent.getGuid() + "</div></html>"), gbc);
        gbc.gridy++;
        this.add(new JLabel("<html><div style = 'width: 1000px;'>" + rssEvent.getDate() + "</div></html>"), gbc);
        gbc.gridy++;
        this.add(new JLabel("<html><div style = 'width: 1000px;'>" + rssEvent.getDescription() + "</div></html>"), gbc);

        // Buttons
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(new MyButton(IconLoader.loadIcon("remove.png"), new OpenRemoveMenuCommand(controller, rssEvent)), gbc);
        gbc.gridx = 2;
        this.add(new MyButton(IconLoader.loadIcon("modify.png"), new OpenModifyMenuCommand(controller, rssEvent)), gbc);

    }
}

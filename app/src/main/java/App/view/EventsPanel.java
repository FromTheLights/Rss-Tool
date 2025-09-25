package App.view;

import java.awt.Color;
import java.awt.GridBagConstraints;

import App.Controller;
import App.RssEventModel;

import javax.swing.BorderFactory;


public class EventsPanel extends PanelTemplate {


    public EventsPanel(Controller controller) {
        super(controller);
    }

    @Override
    public void prepareContent() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // DEBUG

        int i = 0;
        GridBagConstraints gbc;
        PanelTemplate eventPanel;

        for (RssEventModel rssEvent : RssEventModel.getEvents()) {
            gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = i++;
            eventPanel = new EventPanel(controller, rssEvent);
            eventPanel.draw();
            this.add(eventPanel, gbc);
        }
    }

}

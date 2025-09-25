package App.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

import App.Controller;
import App.Commands.OpenAddMenuCommand;
import App.Commands.OpenSaveMenuCommand;
import App.view.styles.IconLoader;

public class ConsultationView extends PanelTemplate {

    public ConsultationView(Controller controller) {
        super(controller);
    }

    @Override
    public void prepareContent() {
        this.setMinimumSize(new Dimension(1500, 800));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;



        PanelTemplate eventsPanel = new EventsPanel(controller);
        eventsPanel.draw();
        JScrollPane scrollPane = new JScrollPane(eventsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(new MyButton(IconLoader.loadIcon("add.png"), new OpenAddMenuCommand(controller)), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0;
        this.add(new MyButton(IconLoader.loadIcon("save.png"), new OpenSaveMenuCommand(controller)), gbc);
    }
}

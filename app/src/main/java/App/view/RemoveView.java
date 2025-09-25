package App.view;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import App.Controller;
import App.RssEventModel;
import App.Commands.CancelCommand;
import App.Commands.RemoveCommand;
import App.view.styles.IconLoader;

public class RemoveView extends PanelTemplate {
    RssEventModel rssEvent;

    public RemoveView(Controller controller, RssEventModel rssEvent) {
        super(controller);
        this.rssEvent = rssEvent;
    }

    @Override
    public void prepareContent() {

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        this.add(new JLabel("Êtes-vous certain de vouloir supprimer cet évènement?"), gbc);

        // Buttons
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        this.add(new MyButton(IconLoader.loadIcon("checkmark.png"), new RemoveCommand(controller, rssEvent)), gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        this.add(new MyButton(IconLoader.loadIcon("x.png"), new CancelCommand(controller)), gbc);
    }

    public RssEventModel getRssEvent() {
        return rssEvent;
    }
}

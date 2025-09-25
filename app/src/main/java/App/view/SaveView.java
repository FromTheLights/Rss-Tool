package App.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import App.Controller;
import App.Commands.CancelCommand;
import App.Commands.ChoosePathCommand;
import App.Commands.SaveCommand;
import App.view.styles.IconLoader;
import App.view.styles.MyTextArea;

public class SaveView extends PanelTemplate {
    MyTextArea path;
    MyTextArea name;

    public SaveView(Controller controller) {
        super(controller);
    }
    
    @Override
    public void prepareContent() {
        // Headers
        this.setPreferredSize(new Dimension(500, 100));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(new JLabel("Chemin : "), gbc);
        gbc.gridy = 1;
        this.add(new JLabel("Nom : "), gbc);

        // Text Areas
        gbc.anchor = GridBagConstraints.CENTER;
        path = new MyTextArea();
        name = new MyTextArea();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        this.add(path, gbc);
        gbc.gridy = 1;
        this.add(name, gbc);

        // Buttons
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.gridy = 0;
        this.add(new MyButton(IconLoader.loadIcon("folder.png"), new ChoosePathCommand(path)));

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weighty = 0;
        this.add(new MyButton(IconLoader.loadIcon("checkmark.png"), new SaveCommand(controller, this)), gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 4;
        gbc.weightx = 1;
        this.add(new MyButton(IconLoader.loadIcon("x.png"), new CancelCommand(controller)), gbc);
    }


    public String getPath() {
        return path.getText();
    }

    public String getName() {
        return name.getText();
    }
}

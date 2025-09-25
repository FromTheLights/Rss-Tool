package App.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import App.Commands.Command;

public class MyButton extends JButton {

    public MyButton(Icon icon, Command command) {
        super(icon);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command.execute();
            }
        });
    }

    
}

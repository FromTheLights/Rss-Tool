package App.Commands;

import java.io.File;

import javax.swing.JFileChooser;
import App.view.styles.MyTextArea;

public class ChoosePathCommand implements Command {
    MyTextArea myTextArea;

    public ChoosePathCommand(MyTextArea myTextArea) {
        this.myTextArea = myTextArea;
    }

    @Override
    public void execute() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setCurrentDirectory(new File("."));
        if (jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION) {
            myTextArea.setText(jfc.getSelectedFile().getAbsolutePath());
        }
    }
}

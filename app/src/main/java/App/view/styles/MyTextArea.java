package App.view.styles;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class MyTextArea extends JTextArea {


    public MyTextArea() {
        super();
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setColumns(50);
        this.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
    }
    
    public MyTextArea(String text) {
        super(text);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setColumns(50);
        this.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
    }
}

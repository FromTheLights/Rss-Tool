package App.view.styles;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconLoader {
    public static final int size = 16;


    public static Icon loadIcon(String path) {
        URL imgURL = IconLoader.class.getClassLoader().getResource(path);
        if (imgURL != null) {
            Icon icon = new ImageIcon(imgURL);
            return IconResize(icon, size);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static Icon IconResize(Icon icon, int size) {
        if (icon == null) {
            return null;
        }
        return new ImageIcon(((ImageIcon) icon).getImage().getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH));
    }
}

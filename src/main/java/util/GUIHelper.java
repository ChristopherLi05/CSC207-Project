package util;

import javax.swing.*;

public class GUIHelper {
    public static JPanel wrapJpanel(JComponent ...components) {
        JPanel panel = new JPanel();
        for (JComponent c : components) {
            panel.add(c);
        }
        return panel;
    }
}

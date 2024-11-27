package util;

import javax.swing.*;

/**
 * Static GUI Helper
 */
public class GUIHelper {
    /**
     * Wraps JComponents in a JPanel to prevent stretching
     * @param components components to wrap
     * @return jpanel containing the elements
     */
    public static JPanel wrapJpanel(JComponent ...components) {
        JPanel panel = new JPanel();
        for (JComponent c : components) {
            panel.add(c);
        }
        return panel;
    }
}

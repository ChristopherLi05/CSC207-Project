package view.component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

/**
 * A panel containing a label and a text field.
 */
public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
        this.setFont(new Font("Arial", Font.PLAIN, 30));
    }
}
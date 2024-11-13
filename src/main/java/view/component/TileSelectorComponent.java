package view.component;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TileSelectorComponent extends JPanel {
    private final List<MahjongTileInputButton> buttons = new ArrayList<>();

    public TileSelectorComponent() {
        // Create buttons here
        // buttons.add(new MahjongTileButton(...));

        // Registers buttons to jpanel
        // TODO: This is not what you're going to do in the final version
        for (MahjongTileInputButton button : buttons) {
            this.add(button);
        }
    }

    public void setActionListener(ActionListener actionListener) {
        for (MahjongTileInputButton button : buttons) {
            button.addActionListener(actionListener);
        }
    }
}

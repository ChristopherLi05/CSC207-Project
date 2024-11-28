package view.component;

import interface_adapter.ViewManager;
import interface_adapter.ViewState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

/**
 * Basic tab switcher component
 */
public class TabSwitcherComponent extends JPanel implements PropertyChangeListener {
    private final ViewManager viewManager;

    public TabSwitcherComponent(ViewManager viewManager) {
        this.viewManager = viewManager;
        viewManager.addPropertyChangeListener(this);
        remakeButtons();
    }

    public void remakeButtons() {
        this.removeAll();

        for (Map.Entry<String, ViewState<?>> pair : viewManager.getViewStates().entrySet()) {
            if (pair.getValue().isTabswitcher()) {
                this.add(createJButton(pair.getKey()));
            }
        }

        this.validate();
        this.revalidate();
        this.repaint();
    }

    /**
     * Creates a JButton based on a view name and tells viewmanager to switch to that view
     * @param viewName .
     * @return created JButton
     */
    public JButton createJButton(String viewName) {
        JButton button = new JButton(viewName);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.addActionListener(e -> viewManager.setView(viewName));
        return button;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("stateAdded")) {
            remakeButtons();
        }
    }
}

package view.component;

import interface_adapter.ViewManager;
import interface_adapter.ViewState;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

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

    public JButton createJButton(String viewName) {
        JButton button = new JButton(viewName);
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
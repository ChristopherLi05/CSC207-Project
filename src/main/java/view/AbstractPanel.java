package view;

import app.IApp;

import javax.swing.*;
import java.beans.PropertyChangeListener;

public abstract class AbstractPanel extends JPanel {
    protected IApp master;

    public AbstractPanel(IApp master) {
        this.master = master;
    }

    public IApp getMaster() {
        return master;
    }
}

package util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StateNotifier<T> {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private T state;

    public StateNotifier(T state) {
        this.state = state;
    }

    public T getState() {
        return this.state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public void firePropertyChanged() {
        this.firePropertyChanged("state");
    }

    public void firePropertyChanged(String propertyName) {
        this.support.firePropertyChange(propertyName, null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }
}

package util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * State notifier class, was originally viewmodel but changed to this
 * @param <T>
 */
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

    /**
     * Notifies listeners that property was changed
     */
    public void firePropertyChanged() {
        this.firePropertyChanged("state");
    }

    /**
     * Notifies listeners that property was changed
     * @param propertyName custom name
     */
    public void firePropertyChanged(String propertyName) {
        this.support.firePropertyChange(propertyName, null, this.state);
    }

    /**
     * Adds property change listener to observers
     * @param listener listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }
}

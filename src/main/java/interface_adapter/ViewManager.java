package interface_adapter;

import util.StateNotifier;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * View Manager that manages the changing views
 */
public class ViewManager extends StateNotifier<String> {
    private final Map<String, ViewState<?>> viewStates = new LinkedHashMap<>();

    public ViewManager() {
        super("");
    }

    /**
     * Sets the gui view
     *
     * @param viewName viewName
     */
    public void setView(String viewName) {
        setState(viewName);
        firePropertyChanged();
    }

    /**
     * Adds a pane to the viewmanager
     *
     * @param viewName  .
     * @param viewState .
     */
    public void addPane(String viewName, ViewState<?> viewState) {
        viewStates.put(viewName, viewState);
        firePropertyChanged("stateAdded");
    }

    /**
     * Gets a list of the view states
     *
     * @return
     */
    public Map<String, ViewState<?>> getViewStates() {
        return viewStates;
    }
}

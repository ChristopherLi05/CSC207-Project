package interface_adapter;

import util.StateNotifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class ViewManager extends StateNotifier<String> {
    private final Map<String, ViewState<?>> viewStates = new LinkedHashMap<>();

    public ViewManager() {
        super("");
    }

    public void setView(String viewName) {
        setState(viewName);
        firePropertyChanged();
    }

    public void addPane(String viewName, ViewState<?> viewState) {
        viewStates.put(viewName, viewState);
        firePropertyChanged("stateAdded");
    }

    public Map<String, ViewState<?>> getViewStates() {
        return viewStates;
    }
}

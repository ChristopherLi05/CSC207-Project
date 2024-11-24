package interface_adapter;

import util.StateNotifier;

import java.util.HashMap;
import java.util.Map;

public class ViewManager extends StateNotifier<String> {
    private final Map<String, ViewState<?>> viewStates = new HashMap<>();

    public ViewManager() {
        super("");
    }

    public void setView(String viewName) {
        setState(viewName);
        firePropertyChanged();
    }

    public void addPane(String viewName, ViewState<?> viewState) {
        viewStates.put(viewName, viewState);
    }

    public Map<String, ViewState<?>> getViewStates() {
        return viewStates;
    }
}

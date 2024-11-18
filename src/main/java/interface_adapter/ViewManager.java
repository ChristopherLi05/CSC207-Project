package interface_adapter;

import util.StateNotifier;

public class ViewManager extends StateNotifier<String> {
    public ViewManager() {
        super("");
    }

    public void setView(String viewName) {
        setState(viewName);
        firePropertyChanged();
    }
}

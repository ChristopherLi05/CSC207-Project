package use_case;

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

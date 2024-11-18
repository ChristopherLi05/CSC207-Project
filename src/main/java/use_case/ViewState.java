package use_case;

import util.StateNotifier;

public class ViewState<T> extends StateNotifier<T> {
    private final String viewName;

    public ViewState(String viewName, T state) {
        super(state);

        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }
}

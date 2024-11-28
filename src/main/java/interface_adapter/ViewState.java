package interface_adapter;

import util.StateNotifier;

/**
 * View State that observes the state; originally view model
 * @param <T>
 */
public abstract class ViewState<T> extends StateNotifier<T> {
    private final String viewName;
    private final boolean tabswitcher;

    public ViewState(String viewName, T state) {
        this(viewName, state, true);
    }

    public ViewState(String viewName, T state, boolean tabswitcher) {
        super(state);

        this.viewName = viewName;
        this.tabswitcher = tabswitcher;
    }

    public String getViewName() {
        return viewName;
    }

//    public boolean isTabswitcher() {
//        return tabswitcher;
//    }
}

package example.com.sqlitesample.presenter;

import android.support.annotation.CallSuper;

public class BasePresenter<V> {

    private V view;

    public BasePresenter() {
    }

    @CallSuper
    public void bind(V view) {
        if (this.view != null) {
           throw new RuntimeException("Concurrent view bind!");
        }
        this.view = view;
    }
}

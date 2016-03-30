package com.example.sqlitesample.presenter;

import com.example.sqlitesample.storage.CommonStorage;
import java.util.List;

import javax.inject.Inject;

import com.example.sqlitesample.db.Category;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class CategoryPresenter extends BasePresenter<CategoryPresenter.Viewing> {

    @Inject
    CommonStorage storage;

    @Inject
    CategoryPresenter() {
    }

    public Observable<List<Category>> getCategoryList() {
        return storage.getCategoryList()
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface Viewing {
    }

}

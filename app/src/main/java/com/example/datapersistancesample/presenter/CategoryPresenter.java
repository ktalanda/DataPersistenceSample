package com.example.datapersistancesample.presenter;

import com.example.datapersistancesample.data.CommonStorage;
import java.util.List;

import javax.inject.Inject;

import com.example.datapersistancesample.data.database.Category;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class CategoryPresenter extends BasePresenter<CategoryPresenter.Viewing> {

    @Inject
    CommonStorage storage;

    @Inject
    CategoryPresenter() {
    }

    public Observable<Category> getCategoryList() {
        return storage.getCategoryList()
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface Viewing {
    }

}

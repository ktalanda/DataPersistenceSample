package com.example.sqlitesample.presenter;

import com.squareup.sqlbrite.BriteDatabase;
import java.util.List;

import javax.inject.Inject;

import com.example.sqlitesample.db.Category;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class CategoryPresenter extends BasePresenter<CategoryPresenter.CategoryViewing> {

    @Inject
    BriteDatabase briteDatabase;

    @Inject
    CategoryPresenter() {
    }

    public Observable<List<Category>> getCategoryList() {
        return briteDatabase.createQuery(Category.TABLE_NAME, Category.SELECT_ALL)
                .mapToList(Category.MAPPER::map)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface CategoryViewing {
    }

}

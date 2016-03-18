package com.example.sqlitesample.presenter;

import com.squareup.sqlbrite.BriteDatabase;
import java.util.List;

import javax.inject.Inject;

import com.example.sqlitesample.db.Category;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class CategoryPresenter extends BasePresenter<CategoryPresenter.CategoryViewing> {

    private static final String LIST_QUERY = ""
            + "SELECT * FROM " + Category.TABLE
            + " WHERE 1";

    @Inject
    BriteDatabase briteDatabase;

    @Inject
    CategoryPresenter() {
    }

    public Observable<List<Category>> getCategoryList() {
        return briteDatabase.createQuery(Category.TABLE, LIST_QUERY)
                .mapToList(Category.MAPPER)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface CategoryViewing {
    }

}

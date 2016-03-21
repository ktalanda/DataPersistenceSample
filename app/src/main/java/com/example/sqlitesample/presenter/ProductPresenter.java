package com.example.sqlitesample.presenter;

import android.content.ContentValues;

import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;

import javax.inject.Inject;

import com.example.sqlitesample.db.Product;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ProductPresenter extends BasePresenter<ProductPresenter.CategoryViewing> {

    @Inject
    BriteDatabase briteDatabase;

    @Inject
    ProductPresenter() {
    }

    public Observable<List<Product>> getProductList(long category) {

        return briteDatabase.createQuery(Product.TABLE_NAME, Product.FOR_CATEGORY, String.valueOf(category))
                .mapToList(Product.MAPPER::map)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void createProduct(long category, String name) {
        ContentValues contentValues
                = new Product.Marshal()
                        .id_category(category)
                        .name(name)
                        .asContentValues();
        briteDatabase.insert(Product.TABLE_NAME, contentValues);
    }

    public void removeProduct(long productId) {
        briteDatabase.delete(Product.TABLE_NAME, Product.ID + " = ?", String.valueOf(productId));
    }

    public interface CategoryViewing {
    }
}

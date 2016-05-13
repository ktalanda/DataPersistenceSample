package com.example.datapersistancesample.data;

import android.content.ContentValues;

import com.example.datapersistancesample.data.database.Category;
import com.example.datapersistancesample.data.database.Product;
import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import rx.Observable;

public class CommonStorage {


    @Inject
    BriteDatabase briteDatabase;

    @Inject
    CommonStorage() {
    }

    public Observable<Category> getCategoryList() {
        return briteDatabase.createQuery(Category.TABLE_NAME, Category.SELECT_ALL)
                .mapToOne(Category.MAPPER::map);
    }

    public Observable<Product> getProductList(long category) {
        return briteDatabase.createQuery(Product.TABLE_NAME, Product.FOR_CATEGORY, String.valueOf(category))
                .mapToOne(Product.MAPPER::map);
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

}

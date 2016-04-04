package com.example.datapersistancesample.data;

import android.content.ContentValues;
import android.content.SharedPreferences;

import com.example.datapersistancesample.data.database.Category;
import com.example.datapersistancesample.data.database.Product;
import com.example.datapersistancesample.data.file.FileAccess;
import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

public class CommonStorage {

    @Inject
    SharedPreferences preferences;

    @Inject
    BriteDatabase briteDatabase;

    @Inject
    FileAccess fileAccess;

    @Inject
    CommonStorage() {
    }

    public void storeString(String key, String value) {
        preferences.edit()
                .putString(key, value)
                .apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public boolean isAvailable(String pref) {
        return preferences.contains(pref);
    }

    public Observable<List<Category>> getCategoryList() {
        return briteDatabase.createQuery(Category.TABLE_NAME, Category.SELECT_ALL)
                .mapToList(Category.MAPPER::map);
    }

    public Observable<List<Product>> getProductList(long category) {
        return briteDatabase.createQuery(Product.TABLE_NAME, Product.FOR_CATEGORY, String.valueOf(category))
                .mapToList(Product.MAPPER::map);
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

    public Observable<List<Map<String, String>>> getNoteList() {
        return fileAccess.getFileContentList();
    }

    public Observable<Map<String, String>> addNote(String content) {
        return fileAccess.addFileWithStringContent(content);
    }

    public Observable<Boolean> removeNote(String name) {
        return fileAccess.removeFile(name);
    }
}

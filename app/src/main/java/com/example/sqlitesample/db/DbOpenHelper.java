package com.example.sqlitesample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, "sample.db", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Category.CREATE_TABLE);
        db.execSQL(Product.CREATE_TABLE);

        long drinksId = db.insert(Category.TABLE_NAME, null, new Category.Marshal().name("Drinks").asContentValues());
        db.insert(Product.TABLE_NAME, null, new Product.Marshal().id_category(drinksId).name("Beer").asContentValues());
        db.insert(Product.TABLE_NAME, null, new Product.Marshal().id_category(drinksId).name("Coke").asContentValues());

        long foodId = db.insert(Category.TABLE_NAME, null, new Category.Marshal().name("Food").asContentValues());
        db.insert(Product.TABLE_NAME, null, new Product.Marshal().id_category(foodId).name("Burger").asContentValues());
        db.insert(Product.TABLE_NAME, null, new Product.Marshal().id_category(foodId).name("Soup").asContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

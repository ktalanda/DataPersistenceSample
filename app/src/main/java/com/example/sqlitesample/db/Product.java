package com.example.sqlitesample.db;

import android.content.ContentValues;
import android.database.Cursor;

import auto.parcel.AutoParcel;
import rx.functions.Func1;

@AutoParcel
public abstract class Product {
    public static final String TABLE = "product";

    public static final String ID = "id_product";
    public static final String ID_CATEGORY = "id_category";
    public static final String NAME = "name";

    public static final Func1<Cursor, Product> MAPPER = cursor -> {
        long id = SampleDatabase.getLong(cursor, ID);
        long idCategory = SampleDatabase.getLong(cursor, ID_CATEGORY);
        String name = SampleDatabase.getString(cursor, NAME);
        return new AutoParcel_Product(id, idCategory, name);
    };

    public abstract long id();
    public abstract long idCategory();
    public abstract String name();

    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder id(long id) {
            values.put(ID, id);
            return this;
        }

        public Builder idCategory(long idCategory) {
            values.put(ID_CATEGORY, idCategory);
            return this;
        }

        public Builder name(String name) {
            values.put(NAME, name);
            return this;
        }

        public ContentValues build() {
            return values;
        }
    }
}

package com.example.datapersistancesample.data.database;

import auto.parcel.AutoParcel;

@AutoParcel
public abstract class Category implements CategoryModel {

    public static final Mapper<Category> MAPPER = new Mapper<>(AutoParcel_Category::new);

    public static final class Marshal extends CategoryMarshal<Marshal> {
    }

}

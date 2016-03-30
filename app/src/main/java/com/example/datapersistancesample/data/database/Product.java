package com.example.datapersistancesample.data.database;

import auto.parcel.AutoParcel;

@AutoParcel
public abstract class Product implements ProductModel {

    public static final Mapper<Product> MAPPER = new Mapper<>(AutoParcel_Product::new);

    public static final class Marshal extends ProductMarshal<Marshal> {
    }

}

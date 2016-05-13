package com.example.datapersistancesample.presenter;

import com.example.datapersistancesample.data.CommonStorage;

import javax.inject.Inject;

import com.example.datapersistancesample.data.database.Product;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ProductPresenter extends BasePresenter<ProductPresenter.Viewing> {

    @Inject
    CommonStorage storage;

    @Inject
    ProductPresenter() {
    }

    public Observable<Product> getProductList(long category) {

        return storage.getProductList(category)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void createProduct(long category, String name) {
        storage.createProduct(category, name);
    }

    public void removeProduct(long productId) {
        storage.removeProduct(productId);
    }

    public interface Viewing {
    }
}

package com.example.sqlitesample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import com.example.sqlitesample.R;
import com.example.sqlitesample.db.Product;
import com.example.sqlitesample.presenter.ProductPresenter;
import rx.functions.Action1;

public class CategoryAdapter extends RecyclerView.Adapter<ProductViewHolder> implements Action1<List<Product>> {

    public List<Product> data;

    @Inject
    ProductPresenter presenter;

    @Inject
    CategoryAdapter() {
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(data.get(position), presenter);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void call(List<Product> products) {
        this.data = products;
        notifyDataSetChanged();
    }
}

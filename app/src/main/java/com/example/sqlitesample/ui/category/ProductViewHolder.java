package com.example.sqlitesample.ui.category;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.sqlitesample.R;
import com.example.sqlitesample.db.Product;
import com.example.sqlitesample.presenter.ProductPresenter;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.product_name)
    TextView name;

    @Bind(R.id.product_edit)
    IconButton productEditButton;

    @Bind(R.id.product_remove)
    IconButton productRemoveButton;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Product product, ProductPresenter presenter) {
        name.setText(product.name());
        productRemoveButton.setOnClickListener(view -> presenter.removeProduct(product.id()));
    }
}

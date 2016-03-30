package com.example.datapersistancesample.ui.category;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.datapersistancesample.R;
import com.example.datapersistancesample.data.database.Product;
import com.example.datapersistancesample.presenter.ProductPresenter;

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

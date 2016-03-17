package example.com.sqlitesample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconButton;
import com.squareup.sqlbrite.BriteDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.sqlitesample.R;
import example.com.sqlitesample.db.Product;

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

    public void bind(Product product, BriteDatabase briteDatabase) {
        name.setText(product.name());
        productRemoveButton.setOnClickListener(view -> briteDatabase.delete(Product.TABLE, Product.ID + " = ?", "" + product.id()));
    }
}

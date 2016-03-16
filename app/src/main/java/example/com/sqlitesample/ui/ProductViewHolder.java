package example.com.sqlitesample.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.sqlitesample.R;
import example.com.sqlitesample.db.Product;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.test)
    TextView test;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Product product) {
        test.setText(product.name());
    }
}

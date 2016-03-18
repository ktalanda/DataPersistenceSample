package example.com.sqlitesample.presenter;

import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;

import javax.inject.Inject;

import example.com.sqlitesample.db.Product;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ProductPresenter extends BasePresenter<ProductPresenter.CategoryViewing> {

    public static final String LIST_PRODUCT = ""
            + "SELECT * FROM " + Product.TABLE
            + " WHERE " + Product.ID_CATEGORY + " = ?";

    @Inject
    BriteDatabase briteDatabase;

    @Inject
    ProductPresenter() {
    }

    public Observable<List<Product>> getProductList(long category) {

        return briteDatabase.createQuery(Product.TABLE, LIST_PRODUCT, "" + category)
                .mapToList(Product.MAPPER)
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void createProduct(long category, String name) {
        briteDatabase.insert(Product.TABLE, new Product.Builder().idCategory(category).name(name).build());
    }

    public void removeProduct(long productId) {
        briteDatabase.delete(Product.TABLE, Product.ID + " = ?", "" + productId);
    }

    public interface CategoryViewing {
    }
}

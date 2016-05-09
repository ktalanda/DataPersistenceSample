package com.example.datapersistancesample.ui.content_provider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.data.contentprovider.AppContentProvider;
import com.example.datapersistancesample.data.database.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContentProviderActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.content_provider_category_list)
    ListView list;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Cursor cursor = getContentResolver()
                .query(
                        Uri.parse(AppContentProvider.BASE_URL + "/" + AppContentProvider.PRODUCT_URL),
                        null,
                        null,
                        null,
                        null);
        List<String> categoryList = new ArrayList<>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                categoryList.add(cursor.getString(cursor.getColumnIndex(Product.NAME)));
            }

            cursor.close();
        }
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, categoryList));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

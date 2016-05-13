package com.example.datapersistancesample.ui.category;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;
import com.example.datapersistancesample.presenter.ProductPresenter;

public class CategoryPageFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";

    @Bind(R.id.category_product_list)
    RecyclerView productList;

    @Inject
    CategoryAdapter categoryAdapter;

    @Inject
    ProductPresenter presenter;

    private long category;

    public CategoryPageFragment() {
    }

    public static CategoryPageFragment newInstance(long category) {
        CategoryPageFragment fragment = new CategoryPageFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getLong(ARG_CATEGORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SampleApp.objectGraph(getContext()).inject(this);
        return inflater.inflate(R.layout.fragment_category_page, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        productList.setLayoutManager(new LinearLayoutManager(getActivity()));
        productList.setAdapter(categoryAdapter);

        presenter.getProductList(category)
                .toList()
                .subscribe(categoryAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @OnClick(R.id.category_product_add)
    public void onProductAddClick(View view) {
        presenter.createProduct(category, "TST");
    }

}

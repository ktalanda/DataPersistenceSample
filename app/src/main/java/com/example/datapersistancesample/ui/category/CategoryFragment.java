package com.example.datapersistancesample.ui.category;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;
import com.example.datapersistancesample.presenter.CategoryPresenter;

public class CategoryFragment extends Fragment {

    @BindView(R.id.category_pager)
    ViewPager categoryPager;

    @BindView(R.id.category_tabs)
    TabLayout categoryTabs;

    @Inject
    CategoryPresenter presenter;

    public CategoryFragment() {
    }

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SampleApp.objectGraph(getContext()).inject(this);
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (categoryPager != null) {
            CategoryPagerAdapter categoryPagerAdapter
                    = new CategoryPagerAdapter(getActivity().getSupportFragmentManager());
            categoryPager.setAdapter(categoryPagerAdapter);
            categoryTabs.setupWithViewPager(categoryPager);
            presenter.getCategoryList().subscribe(categoryPagerAdapter);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

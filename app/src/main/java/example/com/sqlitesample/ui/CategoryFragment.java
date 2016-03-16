package example.com.sqlitesample.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.sqlitesample.R;
import example.com.sqlitesample.SampleApp;
import example.com.sqlitesample.db.Category;
import rx.android.schedulers.AndroidSchedulers;

public class CategoryFragment extends Fragment {

    private static final String LIST_QUERY = ""
            + "SELECT * FROM " + Category.TABLE
            + " WHERE 1";

    @Bind(R.id.category_pager)
    ViewPager categoryPager;

    @Bind(R.id.category_tabs)
    TabLayout categoryTabs;

    @Inject
    BriteDatabase briteDatabase;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
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
        if(categoryPager != null) {
            CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(getActivity().getSupportFragmentManager());
            categoryPager.setAdapter(categoryPagerAdapter);
            categoryTabs.setupWithViewPager(categoryPager);

            briteDatabase.createQuery(Category.TABLE, LIST_QUERY)
                    .mapToList(Category.MAPPER)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(categoryPagerAdapter);
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

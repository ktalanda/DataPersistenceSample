package example.com.sqlitesample.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import example.com.sqlitesample.db.Category;
import rx.functions.Action1;

public class CategoryPagerAdapter extends FragmentPagerAdapter implements Action1<List<Category>> {

    public List<Category> data;

    public CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
        data = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryPageFragment.newInstance(data.get(position).id());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).name();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public void call(List<Category> categories) {
        this.data = categories;
        notifyDataSetChanged();
    }
}

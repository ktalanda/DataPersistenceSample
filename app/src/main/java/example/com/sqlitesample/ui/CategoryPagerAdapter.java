package example.com.sqlitesample.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    public CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryPageFragment.newInstance();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "TEST";
    }

    @Override
    public int getCount() {
        return 3;
    }
}

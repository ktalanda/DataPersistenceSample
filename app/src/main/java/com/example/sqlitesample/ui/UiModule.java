package com.example.sqlitesample.ui;

import com.example.sqlitesample.ui.category.CategoryActivity;
import com.example.sqlitesample.ui.category.CategoryFragment;
import com.example.sqlitesample.ui.category.CategoryPageFragment;
import com.example.sqlitesample.ui.settings.fragment.GeneralPreferenceFragment;
import com.example.sqlitesample.ui.settings.fragment.NotificationPreferenceFragment;

import dagger.Module;

@Module(
        injects = {
                CategoryActivity.class,
                CategoryFragment.class,
                CategoryPageFragment.class,
                GeneralPreferenceFragment.class,
                NotificationPreferenceFragment.class
        },
        complete = false,
        library = true
)
public class UiModule {
}

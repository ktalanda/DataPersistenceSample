package com.example.sqlitesample.ui;

import com.example.sqlitesample.ui.category.CategoryFragment;
import com.example.sqlitesample.ui.category.CategoryPageFragment;

import dagger.Module;

@Module(
        injects = {
                MainActivity.class,
                CategoryFragment.class,
                CategoryPageFragment.class
        },
        complete = false,
        library = true
)
public class UiModule {
}

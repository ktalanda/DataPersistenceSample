package com.example.datapersistancesample.ui;

import com.example.datapersistancesample.ui.category.CategoryActivity;
import com.example.datapersistancesample.ui.category.CategoryFragment;
import com.example.datapersistancesample.ui.category.CategoryPageFragment;

import dagger.Module;

@Module(
        injects = {
                CategoryActivity.class,
                CategoryFragment.class,
                CategoryPageFragment.class,
        },
        complete = false,
        library = true
)
public class UiModule {
}

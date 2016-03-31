package com.example.datapersistancesample.ui;

import com.example.datapersistancesample.ui.category.CategoryActivity;
import com.example.datapersistancesample.ui.category.CategoryFragment;
import com.example.datapersistancesample.ui.category.CategoryPageFragment;
import com.example.datapersistancesample.ui.note.NoteActivity;
import com.example.datapersistancesample.ui.settings.fragment.GeneralPreferenceFragment;
import com.example.datapersistancesample.ui.settings.fragment.NotificationPreferenceFragment;

import dagger.Module;

@Module(
        injects = {
                CategoryActivity.class,
                CategoryFragment.class,
                CategoryPageFragment.class,
                GeneralPreferenceFragment.class,
                NotificationPreferenceFragment.class,
                NoteActivity.class
        },
        complete = false,
        library = true
)
public class UiModule {
}

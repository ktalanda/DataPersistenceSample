package com.example.datapersistancesample.ui;

import com.example.datapersistancesample.ui.settings.fragment.GeneralPreferenceFragment;
import com.example.datapersistancesample.ui.settings.fragment.NotificationPreferenceFragment;

import dagger.Module;

@Module(
        injects = {
                GeneralPreferenceFragment.class,
                NotificationPreferenceFragment.class,
        },
        complete = false,
        library = true
)
public class UiModule {
}

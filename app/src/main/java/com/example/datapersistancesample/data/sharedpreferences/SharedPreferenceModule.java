package com.example.datapersistancesample.data.sharedpreferences;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module(complete = false, library = true)
public class SharedPreferenceModule {
    @Provides
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}

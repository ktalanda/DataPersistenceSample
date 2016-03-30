package com.example.datapersistancesample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.example.datapersistancesample.data.database.DatabaseModule;
import com.example.datapersistancesample.data.sharedpreferences.SharedPreferenceModule;
import com.example.datapersistancesample.ui.UiModule;

@Module(
    includes = {
            DatabaseModule.class,
            UiModule.class,
            SharedPreferenceModule.class
    }
)
public final class SampleModule {
    private final Application application;

    SampleModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton Application provideApplication() {
        return application;
    }
}

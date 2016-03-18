package com.example.sqlitesample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.example.sqlitesample.db.DbModule;
import com.example.sqlitesample.ui.UiModule;

@Module(
    includes = {
            DbModule.class,
            UiModule.class
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

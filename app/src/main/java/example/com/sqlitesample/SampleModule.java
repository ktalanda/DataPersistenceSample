package example.com.sqlitesample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.com.sqlitesample.db.DbModule;
import example.com.sqlitesample.ui.UiModule;

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

package example.com.sqlitesample.ui;

import dagger.Module;

@Module(
        injects = {
                MainActivity.class,
                CategoryFragment.class
        },
        complete = false,
        library = true
)
public class UiModule {
}

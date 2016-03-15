package example.com.sqlitesample;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;
import timber.log.Timber;

public class SampleApp extends Application{
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        objectGraph = ObjectGraph.create(new SampleModule(this));
    }

    public static ObjectGraph objectGraph(Context context) {
        return ((SampleApp)context.getApplicationContext()).objectGraph;
    }
}

package com.example.sqlitesample;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import dagger.ObjectGraph;
import timber.log.Timber;

public class SampleApp extends Application {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        objectGraph = ObjectGraph.create(new SampleModule(this));
        Iconify.with(new FontAwesomeModule());
    }

    public static ObjectGraph objectGraph(Context context) {
        return ((SampleApp) context.getApplicationContext()).objectGraph;
    }
}

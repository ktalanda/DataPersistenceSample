package com.example.sqlitesample.storage;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class CommonStorage {

    private static final String SAMPLE = "SAMPLE";

    @Inject
    SharedPreferences preferences;

    @Inject
    CommonStorage() {
    }

    public void storeSample(String sample) {
        preferences.edit()
                .putString(SAMPLE, sample)
                .apply();
    }

    public String getSample() {
        if (isAvailable(SAMPLE)) {
            throw new IllegalStateException(SAMPLE +" is not stored");
        }
        return preferences.getString(SAMPLE, "");
    }

    public boolean isAvailable(String pref) {
        return preferences.contains(pref);
    }
}

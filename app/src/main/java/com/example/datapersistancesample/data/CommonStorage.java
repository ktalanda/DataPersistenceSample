package com.example.datapersistancesample.data;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class CommonStorage {

    @Inject
    SharedPreferences preferences;


    @Inject
    CommonStorage() {
    }

    public void storeString(String key, String value) {
        preferences.edit()
                .putString(key, value)
                .apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public boolean isAvailable(String pref) {
        return preferences.contains(pref);
    }

}

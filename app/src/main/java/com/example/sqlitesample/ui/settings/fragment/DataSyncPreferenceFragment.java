package com.example.sqlitesample.ui.settings.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sqlitesample.R;
import com.example.sqlitesample.ui.settings.SettingsActivity;

public class DataSyncPreferenceFragment extends android.preference.PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_data_sync);
        setHasOptionsMenu(true);
//        bindPreferenceSummaryToValue(findPreference("sync_frequency"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
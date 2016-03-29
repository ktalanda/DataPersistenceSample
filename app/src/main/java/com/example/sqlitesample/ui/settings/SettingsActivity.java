package com.example.sqlitesample.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.sqlitesample.R;
import com.example.sqlitesample.ui.settings.fragment.GeneralPreferenceFragment;
import com.example.sqlitesample.ui.settings.fragment.NotificationPreferenceFragment;

import java.util.List;

public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_headers, target);
    }

    protected boolean isValidFragment(String fragmentName) {
        return PreferenceFragment.class.getName().equals(fragmentName)
                || GeneralPreferenceFragment.class.getName().equals(fragmentName)
                || NotificationPreferenceFragment.class.getName().equals(fragmentName);
    }


}

package com.example.sqlitesample.ui.settings.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.sqlitesample.R;
import com.example.sqlitesample.SampleApp;
import com.example.sqlitesample.presenter.SettingsPresenter;
import com.example.sqlitesample.ui.settings.SettingsActivity;

import javax.inject.Inject;

public class NotificationPreferenceFragment extends PreferenceFragment {

    @Inject
    SettingsPresenter presenter;

    public NotificationPreferenceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_notification);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SampleApp.objectGraph(getActivity().getBaseContext()).inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        presenter.bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
        super.onViewCreated(view, savedInstanceState);
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

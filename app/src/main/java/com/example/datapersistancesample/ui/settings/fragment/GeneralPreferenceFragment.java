package com.example.datapersistancesample.ui.settings.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;
import com.example.datapersistancesample.presenter.SettingsPresenter;
import com.example.datapersistancesample.ui.settings.SettingsActivity;

import javax.inject.Inject;

public class GeneralPreferenceFragment extends PreferenceFragment {

    @Inject
    SettingsPresenter presenter;

    public GeneralPreferenceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SampleApp.objectGraph(getActivity().getBaseContext()).inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        presenter.bindPreferenceSummaryToValue(findPreference(SettingsPresenter.EXAMPLE_TEXT));
        presenter.bindPreferenceSummaryToValue(findPreference(SettingsPresenter.EXAMPLE_LIST));
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
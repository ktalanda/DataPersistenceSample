package com.example.sqlitesample.presenter;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.RingtonePreference;
import android.text.TextUtils;

import com.example.sqlitesample.R;
import com.example.sqlitesample.storage.CommonStorage;

import javax.inject.Inject;

public class SettingsPresenter extends BasePresenter<SettingsPresenter.Viewing> {

    public static final String EXAMPLE_SWITCH = "example_switch";
    public static final String EXAMPLE_TEXT = "example_text";
    public static final String EXAMPLE_LIST = "example_list";

    public Preference.OnPreferenceChangeListener bindPreferenceSummaryToValueListener;

    @Inject
    CommonStorage storage;

    @Inject
    SettingsPresenter() {
        bindPreferenceSummaryToValueListener
                = (preference, value) -> {
            String stringValue = value.toString();

            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                preference.setSummary(
                        index >= 0
                                ? listPreference.getEntries()[index]
                                : null);
            } else if (preference instanceof RingtonePreference) {
                if (TextUtils.isEmpty(stringValue)) {
                    preference.setSummary(R.string.pref_ringtone_silent);
                } else {
                    Ringtone ringtone = RingtoneManager.getRingtone(
                            preference.getContext(), Uri.parse(stringValue));
                    if (ringtone == null) {
                        preference.setSummary(null);
                    } else {
                        String name = ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);
                    }
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;
        };
    }

    public void bindPreferenceSummaryToValue(Preference preference) {
        preference.setOnPreferenceChangeListener(bindPreferenceSummaryToValueListener);
        bindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                storage.getString(preference.getKey()));
    }

    public interface Viewing {
    }

}

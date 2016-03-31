package com.example.datapersistancesample.ui.note;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datapersistancesample.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewNoteDialogFragment extends DialogFragment {

    @Inject
    public NewNoteDialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_note_new, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.note_add_button)
    public void onAddNoteButtonClick(View view) {
        dismiss();
    }
}

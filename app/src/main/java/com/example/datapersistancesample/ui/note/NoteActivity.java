package com.example.datapersistancesample.ui.note;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteActivity extends AppCompatActivity {

    @Inject
    Provider<NewNoteDialogFragment> newNoteDialogFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        SampleApp.objectGraph(getBaseContext()).inject(this);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.note_new)
    public void onAddNoteClick(View view) {
        DialogFragment dialogFragment = newNoteDialogFragmentProvider.get();

        dialogFragment.show(getFragmentManager(), "dialog");
    }

}

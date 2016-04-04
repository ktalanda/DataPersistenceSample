package com.example.datapersistancesample.ui.note;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;
import com.example.datapersistancesample.presenter.NotePresenter;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteActivity extends AppCompatActivity
        implements NewNoteDialogFragment.OnNewNoteDialogFragmentInteractionListener {

    @Inject
    Provider<NewNoteDialogFragment> newNoteDialogFragmentProvider;

    @Inject
    NoteAdapter noteAdapter;

    @Inject
    NotePresenter presenter;

    @Bind(R.id.note_list)
    RecyclerView noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        SampleApp.objectGraph(getBaseContext()).inject(this);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        noteList.setLayoutManager(new LinearLayoutManager(this));
        noteList.setAdapter(noteAdapter);
        presenter.getNoteList().subscribe(noteAdapter);
    }

    @OnClick(R.id.note_new)
    public void onAddNoteClick(View view) {
        DialogFragment dialogFragment = newNoteDialogFragmentProvider.get();
        dialogFragment.show(getFragmentManager(), "dialog");
    }

    @Override
    public void addNote(Map<String, String> content) {
        noteAdapter.data.add(content);
        noteAdapter.notifyDataSetChanged();
    }
}

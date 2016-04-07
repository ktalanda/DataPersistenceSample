package com.example.datapersistancesample.ui;

import com.example.datapersistancesample.ui.note.NewNoteDialogFragment;
import com.example.datapersistancesample.ui.note.NoteActivity;

import dagger.Module;

@Module(
        injects = {
                NoteActivity.class,
                NewNoteDialogFragment.class
        },
        complete = false,
        library = true
)
public class UiModule {
}

package com.example.datapersistancesample.ui.note;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewNoteDialogFragment extends DialogFragment {

    @Bind(R.id.note_edit_text)
    EditText note;

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
        SampleApp.objectGraph(getActivity().getBaseContext()).inject(this);
        return inflater.inflate(R.layout.fragment_dialog_note_new, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getDialog().setTitle(R.string.note_add_dialog_title);
    }

    @OnClick(R.id.note_add_button)
    public void onAddNoteButtonClick(View view) {
//        String noteString = note.getText().toString();
//        try {
//            FileOutputStream outputStream = getActivity().openFileOutput("note", Context.MODE_PRIVATE);
//            outputStream.write(noteString.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//
//        } finally {
            dismiss();
//        }
    }
}

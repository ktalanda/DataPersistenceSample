package com.example.datapersistancesample.ui.note;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.SampleApp;
import com.example.datapersistancesample.presenter.NotePresenter;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewNoteDialogFragment extends DialogFragment {

    @BindView(R.id.note_edit_text)
    EditText note;

    @Inject
    NotePresenter presenter;

    private OnNewNoteDialogFragmentInteractionListener listener;

    @Inject
    public NewNoteDialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewNoteDialogFragmentInteractionListener) {
            listener = (OnNewNoteDialogFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNewNoteDialogFragmentInteractionListener");
        }
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
        presenter.addNote(note.getText().toString())
            .subscribe(listener::addNote);
        dismiss();
    }

    public interface OnNewNoteDialogFragmentInteractionListener {
        void addNote(Map<String, String> note);
    }

}

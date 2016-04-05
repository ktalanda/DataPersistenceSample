package com.example.datapersistancesample.ui.note;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.presenter.NotePresenter;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.note_text)
    TextView noteText;

    @Bind(R.id.note_remove)
    Button noteRemove;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Map<String, String> note, NotePresenter presenter, Action1<Boolean> deleteAction) {
        Map.Entry<String, String> entry = note.entrySet().iterator().next();
        noteText.setText(entry.getValue());
        noteRemove.setOnClickListener(view ->
                presenter.removeNote(entry.getKey()).subscribe(deleteAction));
    }
}

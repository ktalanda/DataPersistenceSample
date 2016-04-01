package com.example.datapersistancesample.ui.note;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.datapersistancesample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.note_text)
    TextView noteText;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String noteString) {
        noteText.setText(noteString);
    }
}

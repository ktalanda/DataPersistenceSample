package com.example.datapersistancesample.ui.note;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.presenter.NotePresenter;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.functions.Action1;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder>
        implements Action1<List<Map<String, String>>> {

    public List<Map<String, String>> data;

    @Inject
    NotePresenter presenter;

    @Inject
    NoteAdapter() {
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_note, parent, false);

        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.bind(data.get(position), presenter,
                result -> deleteItem(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public void deleteItem(int position) {
        data.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void call(List<Map<String, String>> strings) {
        data = strings;
        notifyDataSetChanged();
    }
}

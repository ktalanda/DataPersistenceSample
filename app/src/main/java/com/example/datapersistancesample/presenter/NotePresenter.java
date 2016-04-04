package com.example.datapersistancesample.presenter;

import com.example.datapersistancesample.data.CommonStorage;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class NotePresenter extends BasePresenter<NotePresenter.Viewing> {

    @Inject
    CommonStorage storage;

    @Inject
    NotePresenter() {
    }

    public Observable<List<Map<String, String>>> getNoteList() {
        return storage.getNoteList()
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Map<String, String>> addNote(String content) {
        return storage.addNote(content);
    }

    public Observable<Boolean> removeNote(String name) {
        return storage.removeNote(name);
    }

    public interface Viewing {
    }

}

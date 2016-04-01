package com.example.datapersistancesample.presenter;

import com.example.datapersistancesample.data.CommonStorage;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class NotePresenter extends BasePresenter<NotePresenter.Viewing> {

    @Inject
    CommonStorage storage;

    @Inject
    NotePresenter() {
    }

    public Observable<List<String>> getNoteList() {
        return storage.getNoteList()
                .observeOn(AndroidSchedulers.mainThread());
    }

    public interface Viewing {
    }

}

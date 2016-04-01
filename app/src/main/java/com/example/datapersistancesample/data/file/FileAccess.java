package com.example.datapersistancesample.data.file;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class FileAccess {

    @Inject
    public FileAccess() {
    }

    public Observable<List<String>> getFileContentList() {
        List<String> notes = new ArrayList<>();
        notes.add("dadasdasda");
        notes.add("dadasdasdad"
                + "adasdasdadadasd"
                + "asdadadasdasdada"
                + "dasdasdadadasdasd"
                + "adadasdasdadadasda"
                + "sdadadasdasdadadas"
                + "dasdadadasdasdadad"
                + "asdasdadadasdasda");
        return Observable.just(notes);
    }
}

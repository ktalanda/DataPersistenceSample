package com.example.datapersistancesample.data.file;

import android.app.Application;
import android.content.Context;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import timber.log.Timber;

public class FileAccess {

    private Context context;

    @Inject
    public FileAccess(Application application) {
        this.context = application;
    }

    public Observable<List<Map<String, String>>> getFileContentList() {
        List<Map<String, String>> notes = new ArrayList<>();
        for (File file : context.getFilesDir().listFiles()) {
            try {
                Map<String, String> map = new HashMap<>();
                map.put(file.getAbsolutePath(), Files.toString(file, Charsets.UTF_8));
                notes.add(map);
            } catch (IOException exception) {
                Timber.e(exception.getMessage());
            }
        }
        return Observable.just(notes);
    }

    public Observable<Map<String, String>> addFileWithStringContent(String content) {
        String fileName = "note_" + new BigInteger(130, new SecureRandom()).toString(32);
        try {
            FileOutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException exception) {
            Timber.e(exception.getMessage());
        }
        Map<String, String> map = new HashMap<>();
        map.put(fileName, content);
        return Observable.just(map);
    }

    public Observable<Boolean> removeFile(String fileName) {
        new File(fileName).delete();
        return Observable.just(true);
    }
}

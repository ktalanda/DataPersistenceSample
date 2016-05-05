package com.example.datapersistancesample.data.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.datapersistancesample.data.CommonStorage;

import javax.inject.Inject;

import timber.log.Timber;

public class AppContentProvider extends ContentProvider {

    private static final String AUTHORITY_NAME = "com.example.datapersistancesample.provider";
    private static final String BASE_URI = "content://" + AUTHORITY_NAME;

    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY_NAME, "test", 1);
    }

    @Inject
    CommonStorage commonStorage;

    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (URI_MATCHER.match(uri)) {
            case 1:
                Timber.d("dasdasdasdasdasdasdasdasdaasd");
                break;
            default:
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

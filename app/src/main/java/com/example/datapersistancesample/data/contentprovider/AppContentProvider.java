package com.example.datapersistancesample.data.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.datapersistancesample.data.database.DbOpenHelper;
import com.example.datapersistancesample.data.database.Product;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import rx.schedulers.Schedulers;
import timber.log.Timber;

public class AppContentProvider extends ContentProvider {

    public static final String AUTHORITY_NAME = "com.example.datapersistancesample.provider";
    public static final String BASE_URL = "content://" + AUTHORITY_NAME;
    public static final String PRODUCT_URL = "product";

    private static final Uri CONTENT_URI = Uri.parse(BASE_URL);
    private static final int PRODUCT = 1;

    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY_NAME, PRODUCT_URL, PRODUCT);
    }

    private BriteDatabase briteDatabase;

    @Override
    public boolean onCreate() {
        SqlBrite sqlBrite = SqlBrite.create(message -> Timber.tag("Database").v(message));
        DbOpenHelper helper = new DbOpenHelper(getContext());
        briteDatabase = sqlBrite.wrapDatabaseHelper(helper, Schedulers.io());
        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                return "vnd.android.cursor.dir/vnd.com.example.datapersistancesample.product";
            default:
                throw new IllegalArgumentException("Unsuported URI:" + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {
        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                return briteDatabase.query("SELECT * FROM product WHERE 1;");
            default:
                throw new IllegalArgumentException("Unsuported URI:" + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        try {
            long id = briteDatabase.insert(Product.TABLE_NAME, values);
            return ContentUris.withAppendedId(CONTENT_URI, id);
        } catch (Exception exception) {
            throw new IllegalArgumentException("Unsuported URI:" + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

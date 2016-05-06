package com.example.datapersistancesample.data.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.datapersistancesample.data.CommonStorage;
import com.example.datapersistancesample.data.database.DbOpenHelper;
import com.example.datapersistancesample.data.database.Product;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Inject;

import rx.schedulers.Schedulers;
import timber.log.Timber;

public class AppContentProvider extends ContentProvider {

    private static final String AUTHORITY_NAME = "com.example.datapersistancesample.provider";
    private static final String BASE_URI = "content://" + AUTHORITY_NAME;
    private static final Uri CONTENT_URI = Uri.parse(BASE_URI);

    private static final int PRODUCT = 1;
    private static final int PRODUCT_ID = 2;

    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY_NAME, "product", PRODUCT);
        URI_MATCHER.addURI(AUTHORITY_NAME, "product/#", PRODUCT_ID);
    }

    @Inject
    CommonStorage commonStorage;

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
                return "";
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
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        try {
            long id = briteDatabase.insert(Product.TABLE_NAME, values);
            return ContentUris.withAppendedId(CONTENT_URI, id);
        } catch (Exception exception) {
            Timber.e("Save product Error.");
            return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        switch (URI_MATCHER.match(uri)) {
            case PRODUCT_ID:
                return briteDatabase
                        .delete(
                                Product.TABLE_NAME,
                                Product.ID + " = ?",
                                String.valueOf(uri.getPathSegments().get(1)));
            default:
                return 0;
        }
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

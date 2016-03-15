package example.com.sqlitesample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, "sample.db", null, VERSION);
    }

    public static final String CREATE_CATEGORY = ""
            + "CREATE TABLE " + Category.TABLE + "("
            + Category.ID + " INTEGER NOT NULL PRIMARY KEY,"
            + Category.NAME + " TEXT NOT NULL"
            + ")";

    public static final String CREATE_PRODUCT = ""
            + "CREATE TABLE " + Product.TABLE + "("
            + Product.ID + " INTEGER NOT NULL PRIMARY KEY,"
            + Product.ID_CATEGORY + " INTEGER NOT NULL REFERENCES " + Category.TABLE + "(" + Category.ID + "),"
            + Product.NAME + " TEXT NOT NULL"
            + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CATEGORY);
        db.execSQL(CREATE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

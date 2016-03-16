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

        long drinksId = db.insert(Category.TABLE, null, new Category.Builder().name("Drinks").build());
        db.insert(Product.TABLE, null, new Product.Builder().idCategory(drinksId).name("Beer").build());
        db.insert(Product.TABLE, null, new Product.Builder().idCategory(drinksId).name("Coke").build());

        long foodId = db.insert(Category.TABLE, null, new Category.Builder().name("Food").build());
        db.insert(Product.TABLE, null, new Product.Builder().idCategory(foodId).name("Burger").build());
        db.insert(Product.TABLE, null, new Product.Builder().idCategory(foodId).name("Soup").build());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

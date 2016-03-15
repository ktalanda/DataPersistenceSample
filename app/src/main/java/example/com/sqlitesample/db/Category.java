package example.com.sqlitesample.db;

import android.content.ContentValues;
import android.database.Cursor;

import auto.parcel.AutoParcel;
import rx.functions.Func1;

@AutoParcel
public abstract class Category {
    public static final String TABLE = "category";

    public static final String ID = "id_category";
    public static final String NAME = "name";

    public abstract long id();
    public abstract String name();

    public static final Func1<Cursor, Category> MAPPER = cursor -> {
        long id = Db.getLong(cursor, ID);
        String name = Db.getString(cursor,NAME);
        return new AutoParcel_Category(id, name);
    };

    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder id(long id){
            values.put(ID, id);
            return this;
        }

        public Builder name(String name) {
            values.put(NAME, name);
            return this;
        }

        public ContentValues build() {
            return values;
        }
    }
}

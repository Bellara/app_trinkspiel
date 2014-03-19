package de.laudert.android.app_trinkspiel.sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Maren on 19.03.14.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="trinkspiel.db";

    public static final String TABLE_CHALLENGES = "challenges";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_CREDITS = "credits";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_CHALLENGES + "( " + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TITLE + " text not null, "
            + COLUMN_TEXT + " text not null, "
            + COLUMN_CREDITS + " integer not null"
            + ");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data!");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHALLENGES);
        onCreate(db);
    }
}

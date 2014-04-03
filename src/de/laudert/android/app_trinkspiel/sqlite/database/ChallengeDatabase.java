package de.laudert.android.app_trinkspiel.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Maren on 19.03.14.
 */
public class ChallengeDatabase {

//    Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_TITLE, MySQLiteHelper.COLUMN_TEXT, MySQLiteHelper.COLUMN_CREDITS};

    public ChallengeDatabase(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Challenge createChallenge(String title, String text, int credits){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_TITLE, title);
        contentValues.put(MySQLiteHelper.COLUMN_TEXT, text);
        contentValues.put(MySQLiteHelper.COLUMN_CREDITS, credits);
        long insertID = database.insert(MySQLiteHelper.TABLE_CHALLENGES, null, contentValues);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_CHALLENGES, allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
        cursor.moveToFirst();
        Challenge newChallenge = cursorToChallenge(cursor);
        cursor.close();
        return newChallenge;
    }

    public void deleteChallenge(Challenge challenge){
        long id= challenge.id;
        System.out.println("Challenge deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_CHALLENGES, MySQLiteHelper.COLUMN_ID + " = " + id, null);
    }

    public ArrayList<Challenge> getAllChallenges(){
        ArrayList<Challenge> challenges = new ArrayList<Challenge>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_CHALLENGES, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Challenge challenge = cursorToChallenge(cursor);
            challenges.add(challenge);
            cursor.moveToNext();
        }
        cursor.close();
        return challenges;
    }

    private Challenge cursorToChallenge(Cursor cursor){
        return new Challenge(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
    }
}

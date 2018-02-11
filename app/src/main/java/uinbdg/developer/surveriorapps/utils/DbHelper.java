package uinbdg.developer.surveriorapps.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by muhammadmishlahulumam on 11/02/18.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "surveymultibahasa.db";
    public static final int DB_VERSION = 1;
    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUMBER = "noHp";
    public static final String COLUMN_ADDRESS = "address";


     /*create table users(
        id integer primary key autoincrement,
        username text,
        password text);
    SQLiteDatabase dbl;
    */
    /*private static final String CREATE_login_table = "create table userlist(id int primary key not null, username text not null, password text not null)";*/

    public static final String CREATE_TABLE_USERS = "create table " + USER_TABLE + "( "
            + COLUMN_ID + " integer primary key, "
            + COLUMN_USERNAME + " varchar, "
            + COLUMN_PASS + " varchar, "
            + COLUMN_NAME + " varchar, "
            + COLUMN_NUMBER + " varchar, "
            + COLUMN_ADDRESS + " text); add auto increment(" + COLUMN_ID + ")";
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public void addUser(String username, String password, String name, String noHp, String address){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASS, password);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_NUMBER, noHp);
        values.put(COLUMN_ADDRESS, address);

        long id = db.insert(USER_TABLE, null, values);
        db.close();
        Log.d(TAG, "user inserted " + id);
    }

    public boolean getUser(String username, String password){
        String selectQuery = "select "+COLUMN_USERNAME+","+COLUMN_PASS+" from " + USER_TABLE + " where " +
                COLUMN_USERNAME + " = " + "'"+username+"'"+ " and "+ COLUMN_PASS + " = " + "'"+password+"';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        db.close();

        return false;
    }
}

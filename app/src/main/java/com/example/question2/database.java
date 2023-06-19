package com.example.question2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context) {
        super(context,"db",null,1);
    }

    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public database(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Friend(" +
                "Id integer  primary key autoincrement,"+
                "Name text ," +
                "Home_address text," +
                "Phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Author");
        onCreate(sqLiteDatabase);
    }
    public int insertFriend(Friend friendContruct) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues content = new ContentValues();
        content.put("Name", friendContruct.getName());
        content.put("Home_address", friendContruct.getAddress());
        content.put("Phone", friendContruct.getPhoneNumber());
        int result = Integer.parseInt(String.valueOf((int) db.insert("Friend", null, content)));
        db.close();
        return result;
    }
    @SuppressLint("SuspiciousIndentation")
    public ArrayList<Friend> getAllfriend() {
        ArrayList<Friend> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Friend", null);
        if (cursor != null) ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Friend(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    public void updateFriend(Friend friend) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", friend.getName());
        values.put("Home_address", friend.getAddress());
        values.put("Phone", friend.getPhoneNumber());
        db.update("Friend", values, "Id"+ " = ?", new String[]{String.valueOf(friend.getId())});
        db.close();
    }
    public int deleteFriend(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String whereClause = "Id=?";
        String whereArgs[] = {id+ ""};
        int result = db.delete("Friend", whereClause ,whereArgs);
        db.close();
        return result;
    }
    public ArrayList<Friend> getAllAuthor() {
        ArrayList<Friend> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Friend", null);
        if (cursor != null) ;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Friend(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
}

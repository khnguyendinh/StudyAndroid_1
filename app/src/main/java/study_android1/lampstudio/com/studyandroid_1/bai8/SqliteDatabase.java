package study_android1.lampstudio.com.studyandroid_1.bai8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VS9 X64Bit on 21/04/2017.
 */

public class SqliteDatabase extends SQLiteOpenHelper {
    public static final String nameDB = "dictionary.db";
    public static final String tableDictionary = "tbl_dictionary";
    public static final String columID = "_id";
    public static final String columWord = "_word";
    public static final String columMean = "_mean";
    public static final int DB_VERSION = 1;
    public static final String Create_Table = "CREATE TABLE "+tableDictionary+"("+
            columID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +columWord+" TEXT NOT NULL, "
            +columMean+" TEXT NOT NULL);";
    public SqliteDatabase(Context context) {
        super(context, nameDB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tableDictionary);
        onCreate(sqLiteDatabase);
    }
    public long InsertRecord(ContentValues contentValues){
       return getWritableDatabase().insert(tableDictionary,null,contentValues);
    }
    public Cursor Rawquery(String sql){
        return getReadableDatabase().rawQuery(sql,null);
    }
    public int UpdateRecord(ContentValues contentValues,String[] id){
        return  getWritableDatabase().update(tableDictionary,contentValues,columID+ " =? ",id);
    }
    public void RemoveRecord(String[] id){
        getWritableDatabase().delete(tableDictionary,columID+ " =? ",id);
    }
}

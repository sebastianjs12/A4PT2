package e.vcu.A4PT2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Judah Sebastian on 4/2/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYNONYM = "synonym";
    private static final String COLUMN_ANTONYM = "antonym";
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "word text not null, synonym text not null , antonym text not null);";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        v.put(COLUMN_ID, count);
        v.put(COLUMN_WORD, c.getWord());
        v.put(COLUMN_SYNONYM, c.getSynonym());
        v.put(COLUMN_ANTONYM, c.getAntonym());
        db.insert(TABLE_NAME, null, v);
        db.close();
    }


    public String searchWord(String s){
        db = this.getReadableDatabase();
        String query = "select id, word, synonym, antonym from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a = "n";
        String b = "d";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(2);
                b = cursor.getString(3);
                if(a.equals(s)){
                    return a;
                }
                else if(b.equals(s)){
                    return b;
                }

            }
            while(cursor.moveToNext());
        }
        return a;
    }
    public String outputPair(String s){
        db = this.getReadableDatabase();
        String query = "select id, word, synonym, antonym from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a = "If you see this you failed";
        String syn, ant;
        String b = "";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(2);
                b = cursor.getString(3);
                if(a.equals(s)){
                    syn = cursor.getString(2);
                    ant = cursor.getString(3);
                    return "Synonym/Antonym pair found : "+syn+" / "+ant;
                }
                else if(b.equals(s)){
                    syn = cursor.getString(2);
                    ant = cursor.getString(3);
                    return "Synonym/Antonym pair found : "+syn+" / "+ant;
                }
            }
            while(cursor.moveToNext());
        }
        return a;
    }


}

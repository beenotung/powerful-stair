package edu.hkcc.personalkcalmanagerhkcc.database.stair;

import android.content.Context;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.Vector;

import edu.hkcc.personalkcalmanagerhkcc.MainActivity;
import edu.hkcc.personalkcalmanagerhkcc.R;
import edu.hkcc.personalkcalmanagerhkcc.database.MyDatabaseHelper;
import edu.hkcc.personalkcalmanagerhkcc.database.stair.StairMapItem;
import edu.hkcc.personalkcalmanagerhkcc.database.stair.StairMapItemDAO;

/**
 * Created by beenotung on 1/17/15.
 */
public class StairMapDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "stairmap.db";
    public static final int VERSION = 1;
    public static StairMapDatabaseHelper current = null;
    public static SQLiteDatabase database;
    public MainActivity mainActivity;

    public StairMapDatabaseHelper(MainActivity mainActivity, SQLiteDatabase.CursorFactory factory) {
        super(mainActivity, DATABASE_NAME, factory, VERSION);
        this.mainActivity = mainActivity;
        myInit();
    }

    public StairMapDatabaseHelper(MainActivity mainActivity, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        super(mainActivity, DATABASE_NAME, factory, VERSION, errorHandler);
        this.mainActivity = mainActivity;
        myInit();
    }

    public static synchronized SQLiteDatabase getDatabase(MainActivity mainActivity) {
        if (current == null)
            current = new StairMapDatabaseHelper(mainActivity, null);
        if (database == null || !database.isOpen())
            database =current.getWritableDatabase();
        return database;
    }
    public static synchronized SQLiteDatabase getDatabase() {
        return getDatabase(current.mainActivity);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myInit();
        Log.w("StairMapDatabaseHelper", "create table");
        db.execSQL(StairMapItemDAO.CREATE_TABLE);
        Log.w("StairMapDatabaseHelper", "insertFromXml");
        insertFromXml();
        Log.w("StairMapDatabaseHelper", "insertFromXml OK");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        database.execSQL(StairMapItemDAO.DROP_TABLE);
        onCreate(db);
    }

    public void insertFromXml() {
        String[] rawStrings = mainActivity.getResources().getStringArray(R.array.stair_map_pair_string_array);
        Vector<StairMapItem> stairMapItems = new Vector<>();
        int j; //buffer
        String upCode = "", downCode = "";
        double distance;
        for (int i = 0; i < rawStrings.length; i++) {
            j = i % 3;
            switch (j) {
                case 0:
                    upCode = rawStrings[i];
                    break;
                case 1:
                    downCode = rawStrings[i];
                    break;
                case 2:
                    distance = Double.parseDouble(rawStrings[i]);
                    stairMapItems.add(new StairMapItem(upCode, downCode, distance));
                    break;
            }
        }
        StairMapItemDAO dao = new StairMapItemDAO(mainActivity);
        for (StairMapItem item : stairMapItems)
            dao.insert(item);
    }


    protected void myInit() {
        current = this;
    }
}
package edu.hkcc.personalkcalmanagerhkcc.database;

import android.content.Context;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.Vector;

import edu.hkcc.personalkcalmanagerhkcc.MainActivity;
import edu.hkcc.personalkcalmanagerhkcc.R;
import edu.hkcc.personalkcalmanagerhkcc.database.stair.StairMapItem;
import edu.hkcc.personalkcalmanagerhkcc.database.stair.StairMapItemDAO;

/**
 * Created by beenotung on 1/17/15.
 */
public class StairMapDatabaseHelper extends MyDatabaseHelper {
    public static final String DATABASE_NAME = "stairmap.db";
    public static final int VERSION = 1;


    public StairMapDatabaseHelper(MainActivity mainActivity, Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(mainActivity, context, name, factory, version);
    }

    public StairMapDatabaseHelper(MainActivity mainActivity, Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(mainActivity, context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }


    public void initDb() {
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
        StairMapItemDAO dao = new StairMapItemDAO(mainActivity, mainActivity);
        for (StairMapItem item : stairMapItems)
            dao.insert(item);
    }
}

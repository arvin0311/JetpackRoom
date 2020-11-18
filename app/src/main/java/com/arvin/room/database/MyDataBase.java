package com.arvin.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.arvin.room.dao.UserDao;
import com.arvin.room.entity.UserModel;

/**
 * MyDataBase
 *
 * @Author yuminghao   2020-11-16   class is cereated
 */

@Database(entities = {UserModel.class}, version = 1)
public abstract class MyDataBase extends RoomDatabase {

    private static MyDataBase instance;

    public static MyDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyDataBase.class, "mydata.db").allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract UserDao userDao();
}

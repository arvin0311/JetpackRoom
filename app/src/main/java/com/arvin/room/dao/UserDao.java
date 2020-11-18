package com.arvin.room.dao;

import android.media.MediaPlayer;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.arvin.room.entity.UserModel;

import java.util.List;

/**
 * UserDao
 *
 * @Author yuminghao   2020-11-16   class is cereated
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER")
    List<UserModel> getAllUsers();

    @Query("SELECT * FROM USER WHERE USER_ID = :id")
    UserModel getUserById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserModel userModel);

    @Query("UPDATE USER SET NAME = :name AND PHONE = :phone WHERE USER_ID = :id")
    void updateUser(int id, String name, String phone);

    @Update(onConflict =  OnConflictStrategy.REPLACE)
    void updateUsers(UserModel... users);

    @Query("DELETE FROM USER WHERE USER_ID = :id")
    void deleteUserById(int id);

    @Delete
    void deleteUsers(UserModel... users);
}

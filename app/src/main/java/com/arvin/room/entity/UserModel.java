package com.arvin.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

/**
 * UserModel
 *
 * @Author yuminghao   2020-11-16   class is cereated
 */

@Data
@Entity(tableName = "USER")
public class UserModel {
    @PrimaryKey
    @ColumnInfo(name = "USER_ID")
    public int id;
    @ColumnInfo(name = "NAME")
    public String name;
    @ColumnInfo(name = "AGE")
    public int age;
    @ColumnInfo(name = "ADDRESS")
    public String address;
    @ColumnInfo(name = "PHONE")
    public String phone;
}

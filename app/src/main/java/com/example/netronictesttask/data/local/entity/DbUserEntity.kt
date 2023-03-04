package com.example.netronictesttask.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class DbUserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "user_id")
    var userId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "phone")
    var phone: String,
    @ColumnInfo(name = "gender")
    var gender: String,
    @ColumnInfo(name = "nationality")
    var nationality: String,
    @ColumnInfo(name = "image_name")
    var imageName: String
)
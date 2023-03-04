package com.example.netronictesttask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.netronictesttask.data.local.entity.DbUserEntity

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<DbUserEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: String): DbUserEntity

    @Query("DELETE FROM users")
    suspend fun deleteAllFromUsers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(insertUsers: List<DbUserEntity>)
}
package com.example.netronictesttask.data.local

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.netronictesttask.BuildConfig.PREVIUOS_VERSION_DB
import com.example.netronictesttask.BuildConfig.VERSION_DB
import com.example.netronictesttask.data.local.dao.UsersDao
import com.example.netronictesttask.data.local.entity.DbUserEntity

@Database(
    entities = [
        DbUserEntity::class
    ],
    version = VERSION_DB,
    autoMigrations = [AutoMigration(from = PREVIUOS_VERSION_DB, to = VERSION_DB)],
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUsersDao() : UsersDao

    companion object {
        private var db_instance: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            if (db_instance != null) return db_instance!!

            synchronized(this) {
                db_instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "main_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                return db_instance!!
            }
        }
    }
}
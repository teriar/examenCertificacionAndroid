package com.example.cl.examen_certifiacion.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [HeroEntity::class, HeroDetailEntity::class], version = 1)
abstract class HeroDatabase:RoomDatabase() {

    abstract fun getPhoneDao(): HeroDao

    companion object{
        @Volatile
        private var INSTANCE: HeroDatabase?= null

        fun getDataBase(context: Context): HeroDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDatabase::class.java,
                    "Phone_database"
                ).build()

                INSTANCE = instance
                return instance


            }
        }
    }
}
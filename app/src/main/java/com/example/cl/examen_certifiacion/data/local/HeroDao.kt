package com.example.cl.examen_certifiacion.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(HeroEntity: HeroEntity)

    @Query("Select * from table_hero order by id asc")
    fun getHeroes(): LiveData<List<HeroEntity>>
}
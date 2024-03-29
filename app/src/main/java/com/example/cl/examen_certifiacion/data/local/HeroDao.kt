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


    //para pruebas android
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(HeroEntity:List<HeroEntity>)


    @Query("Select * from table_hero order by id asc")
    fun getHeroes(): LiveData<List<HeroEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeatilHero(HeroDetailEntity: HeroDetailEntity)

    @Query("Select * from table_Hero_Detail where id like :id")
    fun getDetailHero(id:Int): LiveData<HeroDetailEntity>

}
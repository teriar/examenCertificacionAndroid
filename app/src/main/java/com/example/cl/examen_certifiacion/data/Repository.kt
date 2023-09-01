package com.example.cl.examen_certifiacion.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cl.examen_certifiacion.data.local.HeroDao
import com.example.cl.examen_certifiacion.data.local.HeroDetailEntity
import com.example.cl.examen_certifiacion.data.local.HeroEntity
import com.example.cl.examen_certifiacion.data.remote.Detail_Hero
import com.example.cl.examen_certifiacion.data.remote.Hero
import com.example.cl.examen_certifiacion.data.remote.Hero_Api
import com.example.cl.examen_certifiacion.data.remote.toEntity
import retrofit2.Response

class Repository(private val HeroApi: Hero_Api, private val HeroDao: HeroDao ) {

    fun getHeroEntity(): LiveData<List<HeroEntity>> = HeroDao.getHeroes()
    fun getDetailHero(id:Int): LiveData<HeroDetailEntity> = HeroDao.getDetailHero(id)

    suspend fun  getHeroes(){
        val response: Response<List<Hero>> = HeroApi.getDataList()// aca llegan los datos
        if(response.isSuccessful){ //??llegaron los datos
            val resp = response.body()?.forEach{
                val phoneEntity = it.toEntity()
                HeroDao.insertHero(phoneEntity)
            }
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }


    suspend fun getDetailHeroToEntity(id:Int){
        val response:Response<Detail_Hero> = HeroApi.getDetailHero(id)
        if(response.isSuccessful){
            val detail:Detail_Hero = response.body()!!

            val phoneDetailEntity = detail.toEntity()
            HeroDao.insertDeatilHero(phoneDetailEntity)
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }


}
package com.example.cl.examen_certifiacion.data

import androidx.lifecycle.LiveData
import com.example.cl.examen_certifiacion.data.local.HeroDao
import com.example.cl.examen_certifiacion.data.local.HeroEntity
import com.example.cl.examen_certifiacion.data.remote.Hero_Api

class Repository(private val HeroApi: Hero_Api, private val HeroDao: HeroDao ) {

    fun getHeroEntity(): LiveData<List<HeroEntity>> = HeroDao.getHeroes()

}
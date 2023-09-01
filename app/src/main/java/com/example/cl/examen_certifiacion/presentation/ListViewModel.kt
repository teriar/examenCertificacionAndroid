package com.example.cl.examen_certifiacion.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cl.examen_certifiacion.data.Repository
import com.example.cl.examen_certifiacion.data.local.HeroDatabase
import com.example.cl.examen_certifiacion.data.remote.Hero_Retrofit
import kotlinx.coroutines.launch

class ListViewModel(application: Application):AndroidViewModel(application) {

    private val repository: Repository

    fun heroLiveData()= repository.getHeroEntity()

    fun detailLiveData(id:Int) = repository.getDetailHero(id)

    init {
        val api = Hero_Retrofit.getRetrofitHero()
        val dao = HeroDatabase.getDataBase(application).getHeroDao()
        repository = Repository(api,dao)
    }
    fun getDataHeroes()= viewModelScope.launch {
        repository.getHeroes()
    }
    fun getDetailHero(id:Int)=viewModelScope.launch {
        repository.getDetailHeroToEntity(id)
    }

}
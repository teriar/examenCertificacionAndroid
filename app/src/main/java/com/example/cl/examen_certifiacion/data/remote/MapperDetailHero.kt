package com.example.cl.examen_certifiacion.data.remote

import com.example.cl.examen_certifiacion.data.local.HeroDetailEntity


fun Detail_Hero.toEntity(): HeroDetailEntity = HeroDetailEntity(this.id,this.nombre,this.imagenLink,this.poder,this.año_creacion,this.color,this.traduccion)
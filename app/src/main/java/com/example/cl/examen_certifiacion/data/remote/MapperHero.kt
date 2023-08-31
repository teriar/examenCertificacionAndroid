package com.example.cl.examen_certifiacion.data.remote

import com.example.cl.examen_certifiacion.data.local.HeroEntity

fun Hero.toEntity():HeroEntity = HeroEntity(this.id,this.nombre,this.origen,this.imagenLink, this.poder, this.Año_creacion)
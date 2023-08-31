package com.example.cl.examen_certifiacion.data.local

import androidx.room.Entity
/*
* id": 1,
    "nombre": "BATMAN",
    "origen": "Gotham City",
    "imagenLink": "https://cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/OMMXHLDAABDBVHRUH2FPDLVZCY.jpg",
    "poder": "No tiene super poderes, recurre a su intelecto",
    "Año_creacion": 1939*/
@Entity(tableName = "table_hero", primaryKeys = ["id"])
class HeroEntity (
    val id:Int,
    val nombre:String,
    val origen:String,
    val imagenLink: String,
    val poder:String,
    val Año_creacion:Int

        )
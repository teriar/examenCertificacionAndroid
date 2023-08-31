package com.example.cl.examen_certifiacion.data.local

import androidx.room.Entity

/*
* {
  "id": 1,
  "nombre": "BATMAN",
  "origen": "Gotham City",
  "imagenLink": "https://cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/OMMXHLDAABDBVHRUH2FPDLVZCY.jpg",
  "poder": "No tiene super poderes, recurre a su intelecto",
  "año_creacion": 1939,
  "color": "negro",
  "traduccion": "true"
}
*
*
* */
@Entity(tableName = "table_Hero_Detail", primaryKeys = ["id"])
class HeroDetailEntity (

    val id :Int,
    val nombre:String,
    val imagenLink:String,
    val poder : String,
    val año_creacion: Int,
    val colo: String,
    val traducion: Boolean
        )
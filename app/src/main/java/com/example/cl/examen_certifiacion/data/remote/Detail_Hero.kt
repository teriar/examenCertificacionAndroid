package com.example.cl.examen_certifiacion.data.remote

/*
*{
  "id": 1,
  "nombre": "BATMAN",
  "origen": "Gotham City",
  "imagenLink": "https://cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/OMMXHLDAABDBVHRUH2FPDLVZCY.jpg",
  "poder": "No tiene super poderes, recurre a su intelecto",
  "año_creacion": 1939,
  "color": "negro",
  "traduccion": "true"
}
* */


class Detail_Hero (
    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink : String,
    val poder: String,
    val año_creacion: Int,
    val color: String,
    val traduccion:Boolean
    )
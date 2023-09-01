package com.example.cl.examen_certifiacion.data.local

import com.example.cl.examen_certifiacion.data.remote.Hero
import com.example.cl.examen_certifiacion.data.remote.toEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class test {


    @Test
    fun testToEntity() {

        var Hero = Hero(id = 1, nombre = "gintoki",origen="edo", imagenLink = "sin img", poder = "ninguno", Año_creacion = 2000)
        val result =Hero.toEntity()
        //assertEquals(nombreRaza,result.raza)
        assertThat(result.id).isEqualTo(Hero.id)

    }
}
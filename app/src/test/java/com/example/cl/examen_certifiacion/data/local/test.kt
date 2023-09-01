package com.example.cl.examen_certifiacion.data.local

import com.example.cl.examen_certifiacion.data.remote.Hero
import org.junit.Test

class test {


    @Test
    fun testToEntity() {

        var Hero = Hero(id = 1, name = "telefono", price = 123456, image = "imageUrl")
        val result = phone.toEntity()
        //assertEquals(nombreRaza,result.raza)
        assertThat(result.id).isEqualTo(phone.id)

    }
}
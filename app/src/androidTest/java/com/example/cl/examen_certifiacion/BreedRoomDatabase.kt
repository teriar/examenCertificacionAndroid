package com.example.cl.examen_certifiacion

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.cl.examen_certifiacion.data.local.HeroDao
import com.example.cl.examen_certifiacion.data.local.HeroDatabase
import com.example.cl.examen_certifiacion.data.local.HeroEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class BreedRoomDatabase {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var breedsDao: HeroDao
    private lateinit var db: HeroDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, HeroDatabase::class.java).build()
        breedsDao = db.getHeroDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test


    fun insertBreeds_happyCase_1element() = runBlocking {
        // Given
        val breedList = listOf(HeroEntity(1,"barbilla roja", "ninguno","https://img","volar",2000))

        // When
        breedsDao.insertHero(breedList)

        // Then
        breedsDao.getHeroes().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)
        }
    }

    @Test
    fun insertBreeds_happyCase_3elements() = runBlocking {
        // Given
        val breedList = listOf(HeroEntity(1,"denji","tokyo","https/img1", "hombre motosierra", 2000)
            , HeroEntity(2,"saitama","tokyo","https:/img2","super fuerza",2006)
            , HeroEntity(3,"naruto","aldea de la hoja","https:/img3", "justu", 2000))

        // When
        breedsDao.insertHero(breedList)

        // Then
        breedsDao.getHeroes().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(3)
        }
    }
}


@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}
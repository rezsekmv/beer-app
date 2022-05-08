package com.example.beerapp

import com.example.beerapp.datasource.database.AppDatabase
import com.example.beerapp.model.entity.BeerEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class, manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class PersistenceModuleTest {

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var database: AppDatabase

    @Before
    fun init() {
        hiltAndroidRule.inject()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertAndReadBeerTest() = runTest {
        // Arrange
        val dao = database.beerDao()
        dao.getAll()

//        // Act
//        dao.insertBeer(
//            BeerEntity(
//                id = 1,
//                name = "Soproni",
//                year = "02/1998",
//                description = "Ez egy olcsó magyar sör, minden kocsmában nagyjából ezt csapolják."
//            )
//        )
//
//        // Assert
//        val expectedEntity = BeerEntity(
//            id = 1,
//            name = "Soproni",
//            year = "02/1998",
//            description = "Ez egy olcsó magyar sör, minden kocsmában nagyjából ezt csapolják."
//        )
//
//        assertEquals(expectedEntity, dao.getBeer(1))
//        assertEquals(1, dao.getAll().size)
    }

    @After
    fun close() {
        database.close()
    }
}
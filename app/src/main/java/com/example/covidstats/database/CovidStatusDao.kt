package com.example.covidstats.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.covidstats.model.Country
import com.example.covidstats.model.CovidStatusSummary

@Dao
interface CovidStatusDao {

    @Query("SELECT * FROM status_table ORDER BY date ASC")
    fun getCovidStatus(): LiveData<CovidStatusSummary>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCovidStatusData(statusSummary: CovidStatusSummary)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryStats(countries: List<Country?>)

    @Query("SELECT * FROM country_table ORDER BY country ASC")
    fun getCountryStats(): List<com.example.covidstats.database.localmodel.Country?>
}
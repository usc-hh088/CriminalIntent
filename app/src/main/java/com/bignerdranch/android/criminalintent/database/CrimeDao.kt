package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.criminalintent.Crime
import java.util.UUID

@Dao
interface CrimeDao{
    //asks Room to pull all columns for all rows in the crime database table
    @Query("SELECT * FROM crime")
    suspend fun getCrimes(): List<Crime>

    //asks Room to pull all columns from only the row whose id matches the ID value provided
    @Query("SELECT * FROM crime WHERE id = (:id)")
    suspend fun getCrime(id: UUID): Crime
}

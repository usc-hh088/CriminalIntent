package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.bignerdranch.android.criminalintent.Crime
import java.util.Date

class CrimeDatabase {
    //a list of entity classes
    @Database(entities = [ Crime::class ], version=1)
    //tell your database to use the functions in that class when converting your types
    @TypeConverters(CrimeTypeConverters::class)
    //the version of the database
    abstract class CrimeDatabase : RoomDatabase() {
        abstract fun crimeDao(): CrimeDao
    }

    class CrimeTypeConverters {
        @TypeConverter
        fun fromDate(date: Date): Long {
            return date.time
        }
        @TypeConverter
        fun toDate(millisSinceEpoch: Long): Date {
            return Date(millisSinceEpoch)
        }
    }
}
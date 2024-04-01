
package com.example.weatherko.localdata
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.AlertModel
import com.example.weatherko.model.OneCallHome

@Database(entities = arrayOf(FavouriteLocation::class,OneCallHome::class,AlertModel::class), version = 5)
@TypeConverters(DataConverter::class)
abstract class WeatherDB : RoomDatabase() {
    abstract fun getDao(): DAO

    companion object {
        @Volatile
        private var INSTANCE: WeatherDB? = null
        fun getInstance(ctx: Context): WeatherDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ctx.applicationContext, WeatherDB::class.java, "Weatherko"
                ).fallbackToDestructiveMigration().build()

                instance
            }
        }
    }
}







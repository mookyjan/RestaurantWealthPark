package com.mudassir.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mudassir.data.local.dao.WealthParkDao
import com.mudassir.data.local.models.CityLocalEntity
import com.mudassir.data.local.models.DataEntityLocal
import com.mudassir.data.local.models.FoodLocalEntity


@Database(
    entities = [DataEntityLocal::class, CityLocalEntity::class,FoodLocalEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WealthParkDatabase : RoomDatabase() {
    abstract fun wealthParkDao(): WealthParkDao

    companion object {

//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("CREATE TABLE `productList` (`id` TEXT PRIMARY KEY NOT NULL, `name` TEXT, `status` TEXT, `numLikes` INTEGER, `numComments` INTEGER, `price` INTEGER, `photo` TEXT )")
//            }
//        }

        fun newInstance(context: Context): WealthParkDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                WealthParkDatabase::class.java,
                "wealthpark.db"
            )
//                .addMigrations(MIGRATION_1_2)
                .build()
        }
    }
}
package com.rohaitas.myyotubeproject.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1) // starts with 1
// If we are doing any changes in database we need to update version.. such as adding col, table
abstract class AppDatabase  : RoomDatabase() {
   abstract fun userDao() : UserDao // to perform db operation for that table

   companion object{
       val name = "Name"

       //Crash fixing The Room lib work on java but not on kotin Its a simple fix

       lateinit var instance :AppDatabase

       fun initDatabase(context: Context){  // we need to call this on App onCreate()
           instance = databaseBuilder(context,AppDatabase::class.java , name )
               .build()
       }
   }



    // All Good

}


@Entity  // necessary for db table // Entity also mean table
class User(
    @PrimaryKey(autoGenerate = true) // starts with 1
    val id : Long,
    @ColumnInfo(name = "name")
    val name :String
)

@Dao // an interface for performing db operations
interface UserDao{

    @Query("SELECT * FROM User")
    fun getAllUsers():LiveData<List<User>>

    @Insert
    fun insertUsers(item:User)
    @Delete
    fun deleteUsers(item:User)
}




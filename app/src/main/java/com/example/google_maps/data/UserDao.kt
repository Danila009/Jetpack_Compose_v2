package com.example.google_maps.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM USER_DATA")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM USER_DATA ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>
}
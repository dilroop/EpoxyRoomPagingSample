package com.example.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable


@Dao
interface UserDao {
    @get:Query("SELECT * FROM users")
    val dataSource: DataSource.Factory<Int, User>

    @Query("SELECT * FROM users")
    fun getAll(): Observable<List<User>>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Query("SELECT * FROM users WHERE email LIKE :email LIMIT 1")
    fun findByEmail(email: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}
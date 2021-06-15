package com.example.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable


@Dao
abstract class UserDao {
    @Query("SELECT * FROM users")
    abstract fun getAll(): Observable<List<User>>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    abstract fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    abstract fun findByName(first: String, last: String): User

    @Query("SELECT * FROM users WHERE email LIKE :email LIMIT 1")
    abstract fun findByEmail(email: String): User

    @Insert
    abstract fun insertAll(vararg users: User)

    @Delete
    abstract fun delete(user: User)
}
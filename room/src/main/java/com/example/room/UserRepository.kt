package com.example.room

import android.content.Context
import androidx.room.Room
import io.reactivex.rxjava3.core.Observable

class UserRepository(context: Context) {
    companion object {
        private const val DATABASE_NAME = "custom_database"
    }

    private val userDao = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build().userDao()

    fun getAll(): Observable<List<User>> {
        return userDao.getAll()
    }

    fun loadAllByIds(userIds: IntArray): List<User> {
        return userDao.loadAllByIds(userIds = userIds)
    }

    fun findByName(first: String, last: String): User {
        return userDao.findByName(first = first, last = last)
    }

    fun findByEmail(email: String): User {
        return userDao.findByEmail(email = email)
    }

    fun insertAll(vararg users: User) {
        return userDao.insertAll(users = users)
    }

    fun delete(user: User) {
        return userDao.delete(user = user)
    }
}
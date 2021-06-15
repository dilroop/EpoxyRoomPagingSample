package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.serpro69.kfaker.Faker

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,

    @ColumnInfo(name = "first_name")
    val firstName: String?,

    @ColumnInfo(name = "last_name")
    val lastName: String?,

    @ColumnInfo(name = "email")
    val email: String?
) {
    companion object {
        private val faker = Faker()
        fun createDummyUser(): User {
            val name = faker.name.unique
            return User(
                firstName = name.firstName(),
                lastName = name.lastName(),
                email = "${name.firstName()}.${name.lastName()}@gmail.com"
            )
        }
    }
}

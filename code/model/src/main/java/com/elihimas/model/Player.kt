package com.elihimas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey
    val id: Long? = null,
    val name: String
) {
    constructor(name: String) : this(null, name)
}

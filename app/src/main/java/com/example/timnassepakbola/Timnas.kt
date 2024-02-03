package com.example.timnassepakbola

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Timnas(
    val name: String,
    val description: String,
    val photo: Int,

    // add
    val fullname: String,
    val borndate: String,
    val bornplace: String,
    val heighweight: String,
    val club: String,
    val position: String
):Parcelable

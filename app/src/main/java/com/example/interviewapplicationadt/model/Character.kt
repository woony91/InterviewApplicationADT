package com.example.interviewapplicationadt.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Character(
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: Item? = null,
    val location: Item? = null,
    val image: String = "",
    val episode: List<String> = listOf(),
    val url: String = "",
    val created: String = ""
) : Parcelable {

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Item(
        val name: String = "",
        val url: String = ""
    ) : Parcelable
}
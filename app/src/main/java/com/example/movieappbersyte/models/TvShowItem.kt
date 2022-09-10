package com.example.movieappbersyte.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class TvShowItem(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: @RawValue İmage?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rating")
    val rating: @RawValue Average?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("summary")
    val summary: String?,
):Parcelable
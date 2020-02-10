package com.example.maytheforcebewith.base.model

import com.google.gson.annotations.SerializedName

data class Data(val count : Int,
                @SerializedName("next") val nextUrl : String,
                @SerializedName("previous") val previousUrl : String,
                val results : List<People>)
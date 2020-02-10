package com.example.maytheforcebewith.base.model

import com.example.maytheforcebewith.util.*
import com.google.gson.annotations.SerializedName

data class People(

    @SerializedName(PEOPLE_NAME) val name: String,
    @SerializedName(PEOPLE_HEIGHT) val height: String,
    @SerializedName(PEOPLE_MASS) val mass: String,
    @SerializedName(PEOPLE_HAIR_COLOR) val hairColor: String,
    @SerializedName(PEOPLE_SKIN_COLOR) val skinColor: String,
    @SerializedName(PEOPLE_EYE_COLOR) val eyeColor: String,
    @SerializedName(PEOPLE_BIRTH_YEAR) val birthYear: String,
    @SerializedName(PEOPLE_GENDER) val gender: String,
    @SerializedName(PEOPLE_HOMEWORLD) val homeworld: String,
    @SerializedName(PEOPLE_FILMS) val films: List<String>,
    @SerializedName(PEOPLE_SPECIES) val species: List<String>,
    @SerializedName(PEOPLE_VEHICLES) val vehicles: List<String>,
    @SerializedName(PEOPLE_STARSHIPS) val starships: List<String>,
    @SerializedName(PEOPLE_CREATED) val created: String,
    @SerializedName(PEOPLE_EDITED) val edited: String,
    @SerializedName(PEOPLE_URL) val url: String
)
package com.alexstephanov.ecabscodechallenge.utils

import com.google.gson.Gson
import com.google.gson.JsonElement

inline fun <reified T> JsonElement.fromJson(gson: Gson): T {
    return gson.fromJson(this, T::class.java)
}
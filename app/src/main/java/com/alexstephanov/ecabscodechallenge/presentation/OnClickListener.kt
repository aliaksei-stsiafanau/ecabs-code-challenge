package com.alexstephanov.ecabscodechallenge.presentation

fun interface OnClickListener<T> {
    fun onClick(data: T)
}
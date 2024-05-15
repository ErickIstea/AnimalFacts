package com.istea.animalfacts.main

import kotlinx.serialization.Serializable

@Serializable
data class Modelo(
    val fileSizeBytes: Long,
    val url : String
)
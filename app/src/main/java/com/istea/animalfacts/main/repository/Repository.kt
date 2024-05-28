package com.istea.animalfacts.main.repository

interface Repository {
    suspend fun getFruta() : String
}
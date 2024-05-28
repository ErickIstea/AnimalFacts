package com.istea.animalfacts.main.repository

class MockRepository : Repository {
    override suspend fun getFruta(): String {
        return ""
    }

}
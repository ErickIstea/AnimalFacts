package com.istea.animalfacts.main

sealed class MainEstado {
    data class Correcto(val mensaje:String): MainEstado()
    data class Error(val error:String): MainEstado()
    data object Cargando: MainEstado()
}
package com.istea.animalfacts.main

sealed class MainEstado {
    data object Correcto: MainEstado()
    data object Error: MainEstado()
    data object Cargando: MainEstado()
}
package com.istea.animalfacts.main

sealed class MainIntencion {
    data object Refrescar:MainIntencion()
    data object RomperTodo: MainIntencion()
}
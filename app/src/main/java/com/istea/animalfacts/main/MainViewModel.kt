package com.istea.animalfacts.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var estadoDeUI by mutableStateOf<MainEstado>(MainEstado.Cargando)

    fun ejecutar(intencion: MainIntencion){

    }
}


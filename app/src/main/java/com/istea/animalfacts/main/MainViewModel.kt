package com.istea.animalfacts.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var estadoDeUI by mutableStateOf<MainEstado>(MainEstado.Correcto)

    fun ejecutar(intencion: MainIntencion){
        when(intencion){
            MainIntencion.Refrescar -> refrescar()
            MainIntencion.RomperTodo -> romperTodo()
        }
    }

    private fun refrescar(){
        estadoDeUI = MainEstado.Cargando
    }

    private fun romperTodo(){
        estadoDeUI = MainEstado.Error
    }
}


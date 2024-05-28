package com.istea.animalfacts.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.istea.animalfacts.main.repository.NetworkRepository
import com.istea.animalfacts.main.repository.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: Repository
) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val myRepository = NetworkRepository()
                MainViewModel(
                    repo = myRepository,
                )
            }
        }
    }

    var estadoDeUI by mutableStateOf<MainEstado>(MainEstado.Correcto(""))

    fun ejecutar(intencion: MainIntencion){
        when(intencion){
            MainIntencion.Refrescar -> refrescar()
            MainIntencion.RomperTodo -> romperTodo()
        }
    }

    private fun refrescar(){
        estadoDeUI = MainEstado.Cargando
        viewModelScope.launch {
            val jojo = repo.getFruta()
            estadoDeUI = MainEstado.Correcto(jojo)
        }
    }


    private suspend fun pegarleAlServerDeMentiras(){
        delay(2000)
        estadoDeUI = MainEstado.Correcto("todo ok")
    }

    private fun romperTodo(){
        estadoDeUI = MainEstado.Error("rompi todo")
    }
}


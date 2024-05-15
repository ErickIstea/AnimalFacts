package com.istea.animalfacts.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

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
            pegarleAlServer()
        }
    }

    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }

    private suspend fun pegarleAlServer(){
        try {
            val response = cliente.get("https://random.dog/woof.json")
            if (response.status == HttpStatusCode.OK) {
                val modelo = response.body<Modelo>()
                estadoDeUI = MainEstado.Correcto(modelo.url)

            }else{
                estadoDeUI = MainEstado.Error(response.status.description)
            }
        }catch (e:Exception){
            estadoDeUI = MainEstado.Error(e.message ?: "error desconocido")
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


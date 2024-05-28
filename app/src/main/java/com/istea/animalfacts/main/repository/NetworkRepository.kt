package com.istea.animalfacts.main.repository

import com.istea.animalfacts.main.MainEstado
import com.istea.animalfacts.main.Modelo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkRepository : Repository {

    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    private suspend fun pegarleAlServer(){
        try {
            val response = cliente.get("https://cat-fact.herokuapp.com/facts/random?animal_type=cat")
            if (response.status == HttpStatusCode.OK) {
                val modelo = response.body<Modelo>()
//                estadoDeUI = MainEstado.Correcto(modelo.text)

            }else{
//                estadoDeUI = MainEstado.Error(response.status.description)
            }
        }catch (e:Exception){
//            estadoDeUI = MainEstado.Error(e.message ?: "error desconocido")
        }
    }

    override suspend fun getFruta(): String {
        val response = cliente.get("https://cat-fact.herokuapp.com/facts/random?animal_type=cat")
        if (response.status == HttpStatusCode.OK) {
            val modelo = response.body<Modelo>()
            return modelo.text
        } else {
            throw Exception()
        }
    }
}
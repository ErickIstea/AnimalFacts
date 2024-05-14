package com.istea.animalfacts.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.istea.animalfacts.ui.theme.AnimalFactsTheme
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainPage(modifier: Modifier = Modifier) {
    var viewmodel : MainViewModel = viewModel()
    MainView(modifier = modifier, estado = viewmodel.estadoDeUI){ intencion ->
        viewmodel.ejecutar(intencion)
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier, estado: MainEstado, ejecutar: (MainIntencion)->Unit){
    Text(
        modifier = modifier,
        text = "Hello!"
    )
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    AnimalFactsTheme {
        MainView(estado = MainEstado.Correcto){}
    }
}
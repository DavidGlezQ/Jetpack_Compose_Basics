package com.davidGlez.jetpackcomposebasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/* Seccion 4
* modificador: es un objeto de kotlin que nos poermite cambiar el comportamiento de un componente
* marcado como composable.
* Definir caracteristicas basicas*/

@Preview(showBackground = true, showSystemUi = false, backgroundColor = 0xFFe1e1e1,
    widthDp = 650, heightDp = 320) //device = Devices.
@Composable
private fun ModifierPreview() {
    //NewSpacing()
    //NewSize()
    //NewClick()
    NewResponsive()
}

@Composable
fun NewResponsive(painterRes: Int = R.drawable.ic_launcher_background) {
    BoxWithConstraints {
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(if(minWidth < 720.dp) 8.dp else 32.dp)) {
            if (minWidth > 600.dp) { //isTablet
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = painterRes), contentDescription = null)
                    TextGlobal2(modifier = Modifier.weight(1f))
                    TextGlobal1()
                }
            } else { //isPhone
                Column(modifier = Modifier.padding(8.dp)) {
                    TextGlobal2(modifier = Modifier.fillMaxWidth())
                    TextGlobal1()
                }
            }
        }
    }
}

@Composable
fun NewClick() {
    /*Se le puede agregar el evento click a cualquier composable con modifier*/
    Box(modifier = Modifier
        .padding(16.dp)
        .background(Color.White)) {
        TextGlobal2(modifier = Modifier
            .size(width = 128.dp, height = 64.dp)
            .padding(16.dp)
            /*En compose no es necesario agregar ninguna linea mas para que cualquier composable
            adquiera las propiedades de un btn*/
            //Nota: el orden de los eventos si afecta
            .clickable { }
        )
    }
}

@Composable
fun NewSize() {
    Column(modifier = Modifier
        .size(270.dp)
        .background(Color.Yellow)) {
        Column(modifier = Modifier
            .size(260.dp)
            .background(Color.DarkGray)) {
            TextGlobal1()
            //TextGlobal2(modifier = Modifier.fillMaxWidth())
            //TextGlobal2(modifier = Modifier.fillMaxWidth())
            //TextGlobal2(modifier = Modifier.width(80.dp))
            //equivalente a minWidth y minHeight
            TextGlobal2(modifier = Modifier
                .requiredWidth(80.dp)
                .requiredHeight(40.dp))
        }
        TextGlobal2(modifier = Modifier.size(width = 128.dp, height = 64.dp))
    }
}

@Composable
fun NewSpacing() {
    Box(modifier = Modifier
        .padding(16.dp) //Padding general
        //copy, modificaciones extras sobre el color blanco
        .background(Color.White.copy(alpha = 0.6f))) {
        TextGlobal1()
        TextGlobal2(modifier = Modifier.
        //paddingFromBaseline(top = 24.dp)
        offset(x = 16.dp, y = -8.dp))
    }
}

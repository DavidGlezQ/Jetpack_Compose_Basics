package com.davidGlez.jetpackcomposebasic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Created by David Alejandro González Quezada on 22/12/22.
 */

//showSystemUi muestra la preview como si fuera el telefono
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LayoutPreview() {
    //NewFrameLayout()
    //NewLinearLayout()
    NewConstraintLayout()
}

/*Composeable es como si fuera la vista xml
* En compose el LinearLayout se separa en dos, horizontal y vertical
* */
@Composable
fun NewConstraintLayout() {
    /*ConstraintLayout {
        //Identificadores de todos los componentes
        val (normalA, normalF, filledF, container) = createRefs()
        //Esto es equivalente a layout_constraintTop_toTopOf="parent"
        //Nota: en compose no es necesario dos constraints, con una basta
        Text(text = "normalA", modifier = Modifier.constrainAs(normalA){top.linkTo(parent.top)})
        //Esto es equivalente a layout_constraintTop_toBottomOf
        Text(text = "normalF", modifier = Modifier.constrainAs(normalF){top.linkTo(normalA.bottom)})
        //Esto es equivalente a layout_constraintTop_toTopOf
        TextGlobal2(modifier = Modifier.constrainAs(filledF){
            top.linkTo(normalF.top)
            start.linkTo(normalF.end)
        })
        Row(modifier = Modifier.constrainAs(container){top.linkTo(normalF.bottom)}) {
            TextGlobal1()
            TextGlobal2()
        }
    }*/

    ConstraintLayout {
        val (normalA, normalF, filledF, container) = createRefs()
        val startGuideline = createGuidelineFromStart(0.25f) //valor de 0 a 100, 0 a 1
        val endGuideline = createGuidelineFromEnd(0.5f)
        val topGuideline = createGuidelineFromTop(16.dp)
        val bottomGuideline = createGuidelineFromTop(32.dp)
        Text(text = "normalA", modifier = Modifier.constrainAs(normalA){
            top.linkTo(topGuideline)
            start.linkTo(filledF.end)
        })
        Text(text = "normalF", modifier = Modifier.constrainAs(normalF){
            top.linkTo(normalA.bottom)
            start.linkTo(normalA.start)
        })
        TextGlobal2(modifier = Modifier.constrainAs(filledF){
            top.linkTo(normalF.top)
            start.linkTo(startGuideline)
        })
        Column(modifier = Modifier.constrainAs(container){
            top.linkTo(normalF.bottom)
            start.linkTo(normalA.start)
        }) {
            TextGlobal1()
            TextGlobal2()
        }
    }

}
@Composable
fun NewLinearLayout() {
    //LinearLayout
    //Vertical mode = Colum
    /*Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
        Text(text = "Jetpack Compose!")
        Text(text = "David Glez")

        //Horizontal mode = Row
        Row {
            TextGlobal1()
            TextGlobal2()
        }
    }*/

    Row(verticalAlignment = Alignment.CenterVertically) {
        TextGlobal2()
        Column {
            TextGlobal1()
            Text(text = "Jetpack Compose!")
            Text(text = "David Glez")

            Row {
                TextGlobal1()
                TextGlobal2()
            }
        }
    }
}
//Nota: si escribres comp android studio te da la opcion de crear la funcion mas rapido
@Composable
fun TextGlobal1() {
    Text(text = "Jetpack Compose!", modifier = Modifier.background(Color.Cyan))
}

@Composable
fun TextGlobal2(modifier: Modifier = Modifier) {
    Text(text = "David Glez", modifier = modifier.background(Color.Gray))
}

@Composable
fun NewFrameLayout() {
    //Box = FrameLayout
    Box(contentAlignment = Alignment.CenterEnd) {
        Text(text = "Jetpack Compose!")
        Text(text = "David Glez")
    }
}
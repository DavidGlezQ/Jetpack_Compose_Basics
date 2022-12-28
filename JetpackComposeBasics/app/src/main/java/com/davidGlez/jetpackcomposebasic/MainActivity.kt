package com.davidGlez.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.davidGlez.jetpackcomposebasic.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() { //Ahora hereda de ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //Sustituto de setContentView
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), //Equivalente a match_parent pero para los dos sentidos
                    color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    //NewFrameLayout()
                    //NewLinearLayout()
                    //NewConstraintLayout()
                    //NewSize()
                    NewClick()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
    }
}
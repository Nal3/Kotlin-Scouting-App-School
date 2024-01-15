package com.example.experimentation

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experimentation.ui.theme.ExperimentationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExperimentationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var enteredText by remember { mutableStateOf(TextFieldValue()) }
    var selected by remember {mutableStateOf<Boolean?>(null)}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
            text = "AUTO",
            fontSize = 30.sp
        )
        Box (
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(170.dp)
                .padding(top = 70.dp)
                .border(2.dp, Color.Black, shape = RoundedCornerShape(16.dp))
            ,
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 5.dp,bottom = 5.dp),
                text = "Scout Name",
            )

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(Color.White)
                    .padding(3.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.Center)
                ,
                value = enteredText,
                onValueChange = { newInput -> enteredText = newInput },
                textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.36f)
                .padding(top = 200.dp)
                .border(2.dp, Color.Black, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.TopCenter

        ) {
            Text(
                modifier = Modifier
                    .padding(top = 3.dp),
                text = "Buttons"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = { selected = true },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(if (selected == true) Color.Green else Color.Black)

                ) {
                    Text(text = "yes")
                }
                Button(
                    onClick = { selected = false },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(if (selected == false) Color.Green else Color.Black)

                    ) {
                    Text("no")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExperimentationTheme {
        Greeting()
    }
}
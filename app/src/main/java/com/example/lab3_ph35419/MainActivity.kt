package com.example.lab3_ph35419

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import com.example.lab3_ph35419.ui.theme.Lab3_PH35419Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(modifier = Modifier.padding(12.dp)) {
                GreetingCard(msg = "Trương Văn Quyết - PH35419")
                Spacer(modifier = Modifier.height(10.dp))

                CounterCard()

            }
        }
    }

    @Composable
    fun CounterCard() {
        var count by rememberSaveable { mutableIntStateOf(0) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageCard("You have clicked the button $count times.")
            Button(onClick = { count++ }) {
                Text("Click me")
            }
        }
    }


    @Composable
    fun GreetingCard(msg: String) {
        var text by remember {
            mutableStateOf(msg)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageCard(msg = text)
            Button(onClick = { text = " Hi!" }) {
                Text(text = "Say Hi !")
            }
        }
    }

    @Composable
    fun MessageCard(msg: String) {
        Text(
            text = msg,
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth(),
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }


}





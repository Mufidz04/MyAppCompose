package com.mc0dex.myappcompose.tugas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorApp() {
    val firstNumber = remember { mutableStateOf("") }
    val secondNumber = remember { mutableStateOf("") }
    val result = remember { mutableStateOf("") }
    val operator = remember { mutableStateOf("+")}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Kalkulator") }
            )
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = firstNumber.value, onValueChange = {firstNumber.value = it}, label = { Text("Bilangan Pertama") })
            Spacer(modifier = Modifier.padding(16.dp))
            TextField(value = secondNumber.value, onValueChange = {secondNumber.value = it}, label = { Text("Bilangan Kedua") })
            Text(text = operator.value)
            Row {
                Button(onClick = {operator.value = "+"}) { Text("+") }
                Button(onClick = {operator.value = "-"}) { Text("-") }
                Button(onClick = {operator.value = "*"}) { Text("x") }
                Button(onClick = {operator.value = "/"}) { Text("/") } // Corrected division button text
            }
            Button(
                onClick = {
                    // Calculate result here and update result.value
                    val num1 = firstNumber.value.toDoubleOrNull() ?: 0.0
                    val num2 = secondNumber.value.toDoubleOrNull() ?: 0.0

                    when (operator.value) {
                        "+" -> result.value = (num1 + num2).toString()
                        "-" -> result.value = (num1 - num2).toString()
                        "*" -> result.value = (num1 * num2).toString()
                        "/" -> {
                            if (num2 != 0.0) {
                                result.value = (num1 / num2).roundToInt().toString()
                            } else {
                                result.value = "Error: Division by zero"
                            }
                        }
                        else -> result.value = "Invalid operator"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calculate")
            }
            Spacer(modifier = Modifier.padding(24.dp))
            Column {

            Text(text = "(${result.value})",
                fontSize = 50.sp
            )
            }
        }
    }
}

@Preview
@Composable
private fun CalculatorAppPreview() {
    CalculatorApp()
}
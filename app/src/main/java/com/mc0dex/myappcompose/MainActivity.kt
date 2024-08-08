package com.mc0dex.myappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.mc0dex.myappcompose.tugas.CalculatorApp
import com.mc0dex.myappcompose.tugas.ListViewKota
import com.mc0dex.myappcompose.tugas.MobileInputActivity

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Scaffold() {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomepageContent(navController = navController)
                        }
                        composable("kalkulator") {
                            CalculatorApp() // Replace with your Kalkulator screen
                        }
                        composable("mobileInput") {
                            MobileInputActivity() // Replace with your MobileInputActivity screen
                        }
                        composable("listView") {
                            ListViewKota() // Replace with your ListViewKota screen
                        }
                        }
                    }
                }
            }
        }
    }


@Composable
fun HomepageContent(navController: NavController) {
    data class MenuItem(val title: String, val route: String)

    val menuItems = listOf(
        MenuItem("Project 5:Mobile Input Activity", "mobileInput"),
        MenuItem("Project 5:Kalkulator", "kalkulator"),
        MenuItem("Project 5:ListView Activity", "listView"),
    )

    Surface(
        modifier = Modifier
            .fillMaxSize() // Fills the entire screen
            .padding(top = 56.dp) // Add top padding to push content below TopAppBar
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(menuItems) { menuItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate(menuItem.route)
                        }
                ) {
                    Text(
                        text = menuItem.title,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge // Change text style
                    )
                }
            }
        }
    }
}


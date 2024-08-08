package com.mc0dex.myappcompose.tugas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Kota(val nama: String)

@Composable
fun ListViewKota() {
    val kotaList = listOf(
        Kota("Jakarta"),
        Kota("Bandung"),
        Kota("Surabaya"),
        Kota("Medan"),
        Kota("Denpasar")
    )

    Surface(
        modifier = Modifier
            .fillMaxSize() // Fills the entire screen
            .padding(top = 56.dp) // Add top padding
    ) {
        LazyColumn(
        ) {
            items(kotaList) { kota ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = kota.nama,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)) // Add spacer between items
            }
        }
    }
}

@Composable
fun KotaItem(kota: Kota) {
    Text(text = kota.nama)
}

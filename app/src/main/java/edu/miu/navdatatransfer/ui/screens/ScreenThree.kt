package edu.miu.navdatatransfer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.navigation.NavController
import edu.miu.navdatatransfer.data.Student
import kotlinx.serialization.json.Json

@Composable
fun ScreenThree(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go to Previous")
        }
        // Retrieve the JSON string from the navigation arguments
        val data = navController.currentBackStackEntry?.arguments?.getString("data2")?:"[]"
        //Deserialize json string to student object
        val students: List<Student> = Json.decodeFromString<List<Student>>(data)
        Text(text = "Screen Three: $students")

        Button(onClick = { navController.popBackStack(navController.graph.startDestinationId, false) }) {
            Text(text = "Go to Home")
        }
    }
}
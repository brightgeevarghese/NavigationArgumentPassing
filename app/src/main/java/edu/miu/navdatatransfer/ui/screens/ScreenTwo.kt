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
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun ScreenTwo(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val student = Student("John Doe", 20, "A")
        //Convert student to json string
        val studentData = Json.encodeToString(Student.serializer(), student)
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go to Previous")
        }
        val data = navController.currentBackStackEntry?.arguments?.getString("data")?:"Loading..."
        Text(text = "Screen Two: $data")
        // Button to navigate to "screen-3" with the serialized student data as an argument
        Button(onClick = { navController.navigate("screen-3/$studentData") }) {
            Text(text = "Go to Screen Three")
        }
    }
}
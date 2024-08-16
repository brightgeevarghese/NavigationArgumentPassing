package edu.miu.navdatatransfer.ui.navigation


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.miu.navdatatransfer.ui.components.TopBar
import edu.miu.navdatatransfer.ui.screens.ScreenOne
import edu.miu.navdatatransfer.ui.screens.ScreenThree
import edu.miu.navdatatransfer.ui.screens.ScreenTwo

@Composable
fun App() {
    val navHostController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(navController = navHostController) }
    ) { innerPadding ->
        //create NavHost
        NavHost(navController = navHostController, startDestination = "screen-1") {
            composable("screen-1") {
                ScreenOne(navController = navHostController, modifier = Modifier.padding(innerPadding))
            }
            composable("screen-2/{data}") {
                // Retrieve the data from the arguments,
                // or use a default value if not available
                val data = it.arguments?.getString("data") ?: "No data available"
                // Store the data in the current back stack entry's arguments
                navHostController.currentBackStackEntry?.arguments?.apply {
                    putString("data", data)
                }
                ScreenTwo(navController = navHostController, modifier = Modifier.padding(innerPadding))
            }
            composable("screen-3/{data2}") {
                // Retrieve the data from the arguments,
                // or use a default value if not available
                val data = it.arguments?.getString("data2") ?: "[]"
                // Store the data in the current back stack entry's arguments
                navHostController.currentBackStackEntry?.arguments?.apply {
                    putString("data", data)
                }
                ScreenThree(navController = navHostController, modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

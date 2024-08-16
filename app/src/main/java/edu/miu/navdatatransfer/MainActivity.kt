package edu.miu.navdatatransfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.miu.navdatatransfer.ui.navigation.App
import edu.miu.navdatatransfer.ui.theme.NavDataTransferTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDataTransferTheme {
                val navHostController: NavHostController = rememberNavController()
                App(navHostController = navHostController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavDataTransferTheme {
        val navHostController: NavHostController = rememberNavController()
        App(navHostController = navHostController)
    }
}
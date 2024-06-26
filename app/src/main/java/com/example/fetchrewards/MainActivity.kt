package com.example.fetchrewards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fetchrewards.navigation.Destinations
import com.example.fetchrewards.ui.theme.FetchRewardsTheme
import com.example.fetchrewards.ui.theme.fetchHireeScreen.FetchHiringScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Destinations.FetchHiringScreen.route
                ) {
                    composable(Destinations.FetchHiringScreen.route) {
                        val viewModel = hiltViewModel<MainViewModel>()
                        val state by viewModel.state.collectAsState()
                        Scaffold(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                        ) { innerPadding ->
                            FetchHiringScreen(
                                modifier = Modifier.padding(innerPadding),
                                hireeList = state.hireeList,
                                onHireeClick = { viewModel.onHireeClick(it) },
                                selectedId = state.selectedId
                            )
                        }
                    }
                }
            }
        }
    }
}
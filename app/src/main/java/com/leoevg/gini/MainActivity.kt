package com.leoevg.gini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.leoevg.gini.presentation.ui.theme.GiniTheme
import com.leoevg.gini.presentation.ui.screens.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiniTheme {
                    MainScreen()
                }
            }
        }
    }

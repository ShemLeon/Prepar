package com.leoevg.gini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContentProviderCompat.requireContext
import coil.Coil
import com.leoevg.gini.presentation.ui.theme.GiniTheme
import com.leoevg.gini.presentation.ui.screens.main.MainScreen
import com.leoevg.gini.presentation.ui.util.PixabayLoader
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Coil.setImageLoader(PixabayLoader.create(context = this))
        setContent {
            GiniTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
                    MainScreen()
                }
            }
        }
    }

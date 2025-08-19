package com.leoevg.gini.presentation.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leoevg.gini.presentation.ui.components.PixabayItem
import com.leoevg.gini.presentation.ui.theme.GiniTheme

@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sendEvent(MainScreenEvent.FetchImages)
    }

    if (uiState.value.isLoading) CircularProgressIndicator()
    else InternalContent(uiState)
}

@Composable
private fun InternalContent(uiState: State<MainScreenState>) {
    if (uiState.value.cards.cards.isNotEmpty()){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            items(uiState.value.cards.cards.size) {
                PixabayItem(cardData = uiState.value.cards.cards[it])
            }
        }
    } else {
        Text(
            text = "EMPTY SPISOK",
            fontSize = 30.sp,
            color = Color.Red
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    GiniTheme {
        MainScreen()
    }
}

package com.example.composebasics_state_screen_handling.ui.overview

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composebasics_state_screen_handling.R
import com.example.composebasics_state_screen_handling.ui.theme.ComposeBasics_State_Screen_HandlingTheme

@Composable
fun OverviewScreenRoot() {
    val viewModel = viewModel<OverviewViewModel>()
    OverviewScreen(
        state = viewModel.state
    )
}

@Composable
fun OverviewScreen(
    state: OverviewState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.android_bot),
            contentDescription = null,
            modifier = Modifier.align(
                Alignment.TopCenter
            )
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = state.welcomeTitle,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = state.subtitle,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun OverviewScreenPreview() {
    ComposeBasics_State_Screen_HandlingTheme {
        OverviewScreen(
            OverviewState(
                welcomeTitle = "Hello overview!",
                subtitle = "Subtitle"
            )
        )
    }
}
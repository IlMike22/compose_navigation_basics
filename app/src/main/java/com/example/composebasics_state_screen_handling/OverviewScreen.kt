package com.example.composebasics_state_screen_handling

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composebasics_state_screen_handling.ui.OverviewRoute
import com.example.composebasics_state_screen_handling.ui.OverviewState
import com.example.composebasics_state_screen_handling.ui.OverviewViewModel
import com.example.composebasics_state_screen_handling.ui.theme.ComposeBasics_State_Screen_HandlingTheme

@Composable
fun OverviewScreenRoot() {
    val viewModel = viewModel<OverviewViewModel>()
//    val state by viewModel.state.collectAsStateWithLifecycle()
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
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = state.subtitle,
                color = Color.Black,
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
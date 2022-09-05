package com.example.knowyourhouse.ui.composibles

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.knowyourhouse.ui.framework.ScreenConfig
import com.example.knowyourhouse.ui.framework.rememberScreenConfig
import com.example.knowyourhouse.ui.theme.KnowYourHouseTheme

@Composable
fun MainScreen(text: String) {
    KnowYourHouseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val screenConfig = rememberScreenConfig()
            when (screenConfig.vertical) {
                is ScreenConfig.ScreenSize.Medium -> MediumMainScreen(text = text)
                is ScreenConfig.ScreenSize.Expanded -> ExpandedMainScreen(text = text)
                else -> CompactMainScreen(text = text)
            }
        }
    }
}

@Composable
fun CompactMainScreen(
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = text,
            modifier = Modifier
                .background(Color.Red),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MediumMainScreen(
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = text,
            modifier = Modifier
                .background(Color.Green),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ExpandedMainScreen(
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = text,
            modifier = Modifier
                .background(Color.Blue),
            textAlign = TextAlign.Center
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MainScreenPreview() {
    MainScreen(text = "Preview")
}
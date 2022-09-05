package com.example.knowyourhouse.ui.framework

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ScreenConfig(
    val width: Dp,
    val height: Dp,
    val horizontal: ScreenSize,
    val vertical: ScreenSize
) {
    sealed class ScreenSize {
        object Compact : ScreenSize()
        object Medium : ScreenSize()
        object Expanded : ScreenSize()
    }
}

@Composable
fun rememberScreenConfig(): ScreenConfig {
    val config = LocalConfiguration.current
    val width = config.screenWidthDp
    val height = config.screenHeightDp
    return ScreenConfig(
        width = width.dp,
        height = height.dp,
        horizontal = when {
            width < 600 -> ScreenConfig.ScreenSize.Compact
            width < 840 -> ScreenConfig.ScreenSize.Medium
            else -> ScreenConfig.ScreenSize.Expanded
        },
        vertical = when {
            width < 480 -> ScreenConfig.ScreenSize.Compact
            width < 900 -> ScreenConfig.ScreenSize.Medium
            else -> ScreenConfig.ScreenSize.Expanded
        }
    )
}
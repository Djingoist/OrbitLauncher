/*
 * MomentClock - The central orbital clock
 * First orbit: Moment (time indicator)
 * Shows current hour based on where the Moment sits on the circle
 */

package com.eblan.launcher.design.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eblan.launcher.design.OrbitColors
import com.eblan.launcher.design.OrbitTypography
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

/**
 * MomentClock - The orbital time indicator
 * 
 * @param centerSize - Size of the center circle
 * @param orbitRadius - Radius of the orbital path (first ring)
 * @param currentHour - Current hour (0-23)
 * @param currentMinute - Current minute (0-59)
 */
@Composable
fun MomentClock(
    centerSize: Dp = 100.dp,
    orbitRadius: Dp = 160.dp,
    currentHour: Int,
    currentMinute: Int,
    modifier: Modifier = Modifier
) {
    // Convert time to angle (0 = 12 o'clock, moves clockwise)
    // Full circle = 12 hours, so each hour = 30 degrees
    // But we want continuous movement, so use minutes too
    val totalMinutes = currentHour * 60 + currentMinute
    val angleDegrees = (totalMinutes / 720f) * 360f // 720 minutes in 12 hours

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Draw center circle
        CenterCircle(
            size = centerSize,
            color = OrbitColors.OrbitDim
        )

        // Draw orbital ring
        OrbitRing(
            radius = orbitRadius,
            color = OrbitColors.OrbitDim,
            strokeWidth = 1.dp
        )

        // Draw hour markers around the orbit
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = orbitRadius.toPx()

            for (hour in 0..11) {
                val hourAngle = (hour * 30 - 90) // -90 to start at 12 o'clock
                val angleRad = Math.toRadians(hourAngle.toDouble())

                // Draw hour dot
                val dotX = centerX + (radius * cos(angleRad)).toFloat()
                val dotY = centerY + (radius * sin(angleRad)).toFloat()

                drawCircle(
                    color = OrbitColors.OrbitGray,
                    radius = 4.dp.toPx(),
                    center = Offset(dotX, dotY)
                )
            }
        }

        // Draw the Moment indicator on the orbit
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = orbitRadius.toPx()

            // Adjust angle: 0 degrees = 3 o'clock in Canvas, we want 12 o'clock = 0
            val adjustedAngle = angleDegrees - 90
            val angleRad = Math.toRadians(adjustedAngle.toDouble())

            val momentX = centerX + (radius * cos(angleRad)).toFloat()
            val momentY = centerY + (radius * sin(angleRad)).toFloat()

            // Draw moment (larger, cyan)
            drawCircle(
                color = OrbitColors.OrbitCyan,
                radius = 12.dp.toPx(),
                center = Offset(momentX, momentY)
            )

            // Draw glow
            drawCircle(
                color = OrbitColors.OrbitCyan.copy(alpha = 0.3f),
                radius = 20.dp.toPx(),
                center = Offset(momentX, momentY)
            )
        }

        // Draw hour numerals inside center circle
        HourNumerals(
            centerSize = centerSize,
            currentHour = currentHour,
            currentMinute = currentMinute
        )
    }
}

/**
 * Hour numerals displayed in the center circle
 * Shows current hour and upcoming hour
 */
@Composable
private fun HourNumerals(
    centerSize: Dp,
    currentHour: Int,
    currentMinute: Int
) {
    // Convert 24h to 12h format for display
    val displayHour = if (currentHour == 0) 12 else if (currentHour > 12) currentHour - 12 else currentHour
    val upcomingHour = if (displayHour == 12) 1 else displayHour + 1

    Canvas(modifier = Modifier.size(centerSize)) {
        // Position numerals based on current minute
        // As minute progresses, current hour fades, upcoming hour appears
        val progress = currentMinute / 60f

        // This is simplified - we'd position them on a gradient based on progress
    }
}
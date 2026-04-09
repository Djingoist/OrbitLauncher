/*
 * OrbitRing - Core orbital composable
 * The foundation for Moment, Calendar, and Notification orbits
 */

package com.eblan.launcher.designsystem.design.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * Draws an orbital ring
 * @param radius - radius in dp
 * @param color - ring color
 * @param strokeWidth - thickness of the ring line
 */
@Composable
fun OrbitRing(
    radius: Dp,
    color: Color = Color(0xFF444444),
    strokeWidth: Dp = 2.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(radius * 2)) {
        val centerX = size.width / 2
        val centerY = size.height / 2

        drawCircle(
            color = color,
            radius = radius.toPx(),
            center = Offset(centerX, centerY),
            style = Stroke(width = strokeWidth.toPx())
        )
    }
}

/**
 * Calculate position on an orbit ring given an angle (in degrees)
 */
fun orbitPosition(
    radius: Dp,
    angleDegrees: Float,
    centerX: Float,
    centerY: Float
): Offset {
    val angleRadians = Math.toRadians(angleDegrees.toDouble())
    return Offset(
        x = centerX + (radius.toPx() * cos(angleRadians)).toFloat(),
        y = centerY + (radius.toPx() * sin(angleRadians)).toFloat()
    )
}

/**
 * Draw an item on an orbit
 */
@Composable
fun OrbitalItem(
    radius: Dp,
    angleDegrees: Float,
    size: Dp,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(size)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val pos = orbitPosition(radius, angleDegrees, centerX, centerY)

            drawCircle(
                color = color,
                radius = size.toPx() / 2,
                center = pos
            )
        }
    }
}

/**
 * Center circle - the "Home" base
 */
@Composable
fun CenterCircle(
    size: Dp,
    color: Color = Color(0xFF444444),
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size)) {
        val centerX = size.width / 2
        val centerY = size.height / 2

        // Fill
        drawCircle(
            color = color.copy(alpha = 0.3f),
            radius = size.toPx() / 2,
            center = Offset(centerX, centerY)
        )

        // Stroke
        drawCircle(
            color = color,
            radius = size.toPx() / 2,
            center = Offset(centerX, centerY),
            style = Stroke(width = 2.dp.toPx())
        )
    }
}
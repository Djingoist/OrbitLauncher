/*
 * OrbitLauncher Typography
 * Monospace, retro styling
 */

package com.eblan.launcher.designsystem.design

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Re-export colors for convenience
private val OrbitWhite = Color(0xFFE8E8E8)
private val OrbitGray = Color(0xFF888888)
private val OrbitCyan = Color(0xFF00F5D4)

object OrbitTypography {
    // Main time display - large monospace numerals
    val timeDisplay = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        color = OrbitWhite
    )

    // Hour numerals on the center circle
    val hourNumeral = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = OrbitGray
    )

    // Hour numeral when active (the "coming" hour)
    val hourNumeralActive = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = OrbitCyan
    )

    // Notification timestamps
    val notificationTime = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = OrbitGray
    )

    // Notification sender
    val notificationSender = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = OrbitWhite
    )

    // Notification preview text
    val notificationPreview = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = OrbitGray
    )

    // Filter tabs
    val filterTab = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = OrbitGray
    )

    val filterTabActive = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = OrbitCyan
    )
}
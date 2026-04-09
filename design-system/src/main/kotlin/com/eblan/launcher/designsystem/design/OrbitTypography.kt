/*
 * OrbitLauncher Typography
 * Monospace, retro styling
 */

package com.eblan.launcher.design

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eblan.launcher.design.OrbitColors.OrbitWhite
import com.eblan.launcher.design.OrbitColors.OrbitGray
import com.eblan.launcher.design.OrbitColors.OrbitCyan

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
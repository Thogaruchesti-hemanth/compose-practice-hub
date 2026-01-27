package com.example.composeplayground

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp


fun Float.toDp(density: Density): Dp = with(density) { this@toDp.toDp() }

fun getUltraSmoothedEdgesShape(
    flareWidth: Float,
    flareHeight: Float,
    cornerSize: Float,
    hasStartFlare: Boolean,
    hasEndFlare: Boolean
) = GenericShape { size, _ ->
    val fw = flareWidth
    val fh = flareHeight
    val cs = cornerSize
    val w = size.width
    val h = size.height

    if (hasStartFlare) {
        moveTo(0f, 0f)
        cubicTo(fw * 0.8f, 0f, fw, fh * 0.4f, fw, fh)
        lineTo(fw, h - cs)
    } else {
        moveTo(0f, 0f)
        lineTo(0f, h - cs)
    }

    val lx = if (hasStartFlare) fw else 0f
    cubicTo(lx, h - (cs * 0.4f), lx + (cs * 0.4f), h, lx + cs, h)

    val rx = w - (if (hasEndFlare) fw else 0f)
    lineTo(rx - cs, h)
    cubicTo(rx - (cs * 0.4f), h, rx, h - (cs * 0.4f), rx, h - cs)

    if (hasEndFlare) {
        lineTo(rx, fh)
        cubicTo(rx, fh * 0.4f, rx + (fw * 0.2f), 0f, w, 0f)
    } else {
        lineTo(w, 0f)
    }
    close()
}

/**
 * A custom spring configuration for Shared Element Transitions.
 * Low stiffness (100f) creates a slow, floaty movement.
 * Damping ratio (0.85f) ensures a soft, organic landing without excessive vibration.
 */
val playfulSpring = spring<Rect>(
    dampingRatio = 0.85f,
    stiffness = 100f
)



/**
 * Provides the [SharedTransitionScope] to children without passing it as a function parameter.
 * This avoids `VerifyError` crashes on certain Android runtimes caused by complex method signatures.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }

/**
 * Provides the [AnimatedVisibilityScope] to children, required for Shared Element transitions.
 */
val LocalAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }
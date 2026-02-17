# Basics Codelab

A Jetpack Compose sample that demonstrates onboarding flow, a scrollable list of greetings, and spring-based expand/collapse animation.

## Features

- Onboarding screen gated by `rememberSaveable` so state survives recomposition and screen rotation
- `LazyColumn` rendering 1000 items efficiently without composing off-screen items
- Per-item expand/collapse toggle with `remember { mutableStateOf(false) }`
- `animateDpAsState` with a `spring` animation spec (`DampingRatioMediumBouncy`, `StiffnessLow`) for a bouncy expand effect
- `coerceAtLeast(0.dp)` guard to prevent negative padding during animation
- `rememberSaveable` vs `remember` — onboarding state persists across config changes, item state does not

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `rememberSaveable`, `mutableStateOf`
- [Compose Animation](https://developer.android.com/jetpack/compose/animation) - `animateDpAsState`, `spring`, `Spring`
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `LazyColumn`, `Column`, `Row`, `Surface`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `ButtonDefaults`, `MaterialTheme`

## Reference

This project is inspired by the [Google Developer Training](https://github.com/android/codelab-android-compose) course by Google.

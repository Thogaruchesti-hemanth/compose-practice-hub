# Tip Time

A Jetpack Compose sample that calculates a tip amount based on bill total, tip percentage, and an optional round-up toggle.

## Features

- Two `TextField` inputs for bill amount and tip percentage with numeric keyboard and `ImeAction`
- `Switch` toggle to round the tip up to the nearest whole number via `kotlin.math.ceil`
- Tip calculated reactively — result updates as the user types with no button needed
- `toDoubleOrNull()` for safe string-to-number conversion with a fallback to `0.0`
- `NumberFormat.getCurrencyInstance()` for locale-aware currency formatting
- Edge-to-edge layout with `enableEdgeToEdge()`, `statusBarsPadding()`, and `safeDrawingPadding()`
- Scrollable layout with `verticalScroll(rememberScrollState())` for small screens

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

Add `money` and `percent` vector drawables to `res/drawable/` and the required strings to `res/values/strings.xml`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `mutableStateOf`, recomposition
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Row`, `Spacer`, `Modifier`
- [Compose Text & Input](https://developer.android.com/jetpack/compose/text) - `TextField`, `KeyboardOptions`, `ImeAction`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `Switch`, `Surface`, `MaterialTheme`

## Reference

This project is inspired by the [Google Developer Training](https://github.com/google-developer-training/basic-android-kotlin-compose-training-tip-calculator) course by Google.

# Lemonade

A Jetpack Compose sample that walks through making lemonade step by step — from picking a lemon to drinking a glass.

## Features

- Multi-step UI flow managed with `currentStep` state via `mutableIntStateOf`
- Random squeeze count using `(2..4).random()` before advancing to the next step
- Reusable `LemonTextAndImage` composable driven entirely by parameters and a lambda callback
- `Scaffold` with `CenterAlignedTopAppBar` and Material3 color scheme tokens
- Dimensions managed via `res/values/dimens.xml` and `dimensionResource()`

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

Add the following drawables to `res/drawable/`: `lemon_tree`, `lemon_squeeze`, `lemon_drink`, `lemon_restart`.  
Add corresponding strings and dimensions to `res/values/strings.xml` and `res/values/dimens.xml`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `mutableIntStateOf`, recomposition
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Box`, `Column`, `Scaffold`, `Spacer`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `CenterAlignedTopAppBar`, `ButtonDefaults`, color scheme

## Reference

This project is inspired by the [Google Developer Training](https://github.com/google-developer-training/basic-android-kotlin-compose-training-lemonade) repo by Google.

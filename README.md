# Dice Roller

A Jetpack Compose sample that rolls a dice and displays the result as an image on button tap.

## Features

- State-driven UI using `remember` and `mutableStateOf`
- Dice face image swapped via a `when` expression on state
- Button click triggers `(1..6).random()` to update state and recompose
- Centered layout using `wrapContentSize(Alignment.Center)`

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

Add six dice face images to `res/drawable/` named `dice_1` through `dice_6`, and a `roll` string to `res/values/strings.xml`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `mutableStateOf`, recomposition
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Spacer`, `Modifier`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `Button`, `Surface`

## Reference

This project is inspired by the [Android Basics with Compose](https://github.com/google-developer-training/basic-android-kotlin-compose-training-dice-roller) course by Google.

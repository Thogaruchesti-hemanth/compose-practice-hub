# Wellness App

A Jetpack Compose sample that tracks daily water intake and a list of wellness tasks with check and dismiss functionality.

## Features

- `ViewModel` integration via `viewModel()` to hoist and survive state across recompositions
- State hoisting pattern — `StatelessCounter` takes `count` and `onIncrement` as parameters, making it independently testable and reusable
- `rememberSaveable` for water counter so the count survives configuration changes
- `toMutableStateList()` in the ViewModel for a list that triggers recomposition on item addition or removal
- `Checkbox` and `IconButton` with `Icons.Filled.Close` for task check and dismiss interactions
- Button disabled via `enabled = count < 10` to cap water intake at 10 glasses

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

Add the `androidx.lifecycle:lifecycle-viewmodel-compose` dependency to your `build.gradle` to enable `viewModel()`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `rememberSaveable`, `toMutableStateList`, state hoisting
- [ViewModel](https://developer.android.com/jetpack/compose/state#viewmodels-as-state-owners) - `viewModel()`, state ownership across recomposition
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Row`, `LazyColumn`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `Checkbox`, `IconButton`, `Button`

## Reference

This project is inspired by the [Google Developer Training](https://github.com/android/codelab-android-compose/tree/main/BasicStateCodelab) course by Google.

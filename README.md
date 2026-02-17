# MySoothe

A Jetpack Compose sample that displays a wellness app with adaptive layout support for both portrait and landscape orientations.

## Features

- Adaptive layout using `WindowSizeClass` — `NavigationBar` on compact, `NavigationRail` on expanded
- `LazyRow` for a horizontally scrollable body alignment section
- `LazyHorizontalGrid` with fixed 2 rows for a favorite collections grid
- Slot API pattern via `HomeSection` composable that accepts a `content: @Composable () -> Unit` lambda
- Circular image clipping with `.clip(CircleShape)` and `ContentScale.Crop`
- `Scaffold` with `bottomBar` slot wired to `SootheBottomNavigation`
- `paddingFromBaseline` for precise text spacing relative to the text baseline
- `NavigationRail` and `NavigationBar` driven by `NavigationRailItem` and `NavigationBarItem` from Material3

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

Add body and collection images to `res/drawable/` and the required strings to `res/values/strings.xml`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Row`, `LazyRow`, `LazyHorizontalGrid`, `Scaffold`
- [Adaptive Layout](https://developer.android.com/jetpack/compose/layouts/adaptive) - `WindowSizeClass`, `WindowWidthSizeClass`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `NavigationBar`, `NavigationRail`, `Surface`, `TextFieldDefaults`

## Reference

This project is inspired by the [Google Developer Training](https://github.com/android/codelab-android-compose/tree/main/BasicLayoutsCodelab) course by Google.

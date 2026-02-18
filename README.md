# Art Space

A Jetpack Compose sample that displays a gallery of artworks with navigation controls to browse through them.

## Features

- `data class Artwork` to hold image resource, title, artist, and year for each item
- `remember` + `mutableStateOf` to track the current artwork index with Previous / Next buttons
- Buttons conditionally enabled — Previous disabled at first item, Next disabled at last item
- `buildAnnotatedString` with `SpanStyle` to bold the artist name inline with the year
- `Card` with `elevation` and `ContentScale.Crop` for the artwork image display
- `LocalConfiguration` to read screen width and apply a responsive `contentWidth` for tablet support
- `weight(1f)` on the image Card so it fills remaining vertical space between title and buttons

## Getting Started

Clone the repo and open in Android Studio. Add four drawable images named `image_1` through `image_4` to `res/drawable/`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `mutableStateOf`, recomposition
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Box`, `Column`, `Row`, `Spacer`, `Modifier.weight()`
- [Compose Text](https://developer.android.com/jetpack/compose/text) - `buildAnnotatedString`, `SpanStyle`, `withStyle`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `Card`, `Surface`, `Button`, `MaterialTheme`

## Reference

This project is inspired by the [Google Developer Training](https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-art-space#0) course by Google.

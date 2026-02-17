# Business Card

A Jetpack Compose sample that displays a digital business card with a profile picture, name, title, and contact information.

## Features

- Profile image with top padding layout using `Column`
- Reusable `AddInfo` composable for contact rows with `Icon` + `Text`
- Background tint using `Color.copy(alpha)` for a soft green wash
- Contact section built with Android system drawable icons

## Getting Started

Clone the repo and open in Android Studio. No additional setup required.

Add your profile image to `res/drawable/` as `ic_profile_pic`.

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Row`, `Spacer`, `Modifier`
- [Compose UI](https://developer.android.com/jetpack/compose/text) - `Text`, `Image`, `Icon`

## Reference

This project is inspired by the [Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course) course by Google.

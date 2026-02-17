# Compose Onboarding Screen Template

A reusable, production-ready Jetpack Compose onboarding screen template. Clone it, swap the content, and drop it into any new project.

## Usage

Copy the `ui/onboardingScreen` package into your project. Update `OnboardingPage` with your own titles, descriptions, images, and button labels. Wire `onButtonClick` to your navigation logic to move to the next page or finish onboarding.

```kotlin
OnboardingPageContent(
    page = OnboardingPage(
        image = R.drawable.your_image,
        title = "Your Title",
        description = "Your description here.",
        buttonText = "Next"
    ),
    currentPage = 0,
    totalPages = 3,
    onButtonClick = { /* navigate */ }
)
```

## Structure

```
ui/onboardingScreen/
├── OnboardingPageContent.kt   # Root composable — assembles the full page
├── OnboardingPage.kt          # Data class holding page content
└── components/
    ├── OnboardingImage.kt     # Full-width illustration
    ├── OnboardingText.kt      # Title + description block
    ├── DotsIndicator.kt       # Page progress dots
    └── OnboardingButton.kt    # CTA button
```

## What You Can Learn From This

- **Component decomposition** — each visual concern lives in its own composable under `components/`, making them independently previewable and reusable
- **Data-driven UI** — `OnboardingPage` is a plain data class; the composable just renders what it receives, with no hardcoded strings or images inside the UI layer
- **Slot-style layout with `Arrangement.SpaceBetween`** — image, text, dots, and button each occupy their own zone without manual spacing math
- **Separation of concerns** — `OnboardingPageContent` owns layout only; navigation logic lives entirely in the caller via `onButtonClick`
- **Scalable pattern** — adding a new page means adding a data entry, not touching any composable

## Where You Can Use This

- Any app that needs a first-launch walkthrough
- Feature introduction screens after an update
- Permission explanation flows before requesting sensitive permissions
- Trial or subscription pitch screens

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Spacer`, `Arrangement.SpaceBetween`
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - wire `onButtonClick` to `NavController` to advance pages

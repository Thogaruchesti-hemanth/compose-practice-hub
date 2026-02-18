# Branch Index

> A catalogue of all branches in this repo. Each branch is a self-contained Jetpack Compose project.
> Open this file on `master`, pick a branch, and run `git checkout branch-name`.


## Difficulty

| Stars | Means |
|-------|-------|
| ⭐ | Pure UI — layouts and composables only, no logic |
| ⭐⭐ | Adds interactivity and basic state management |
| ⭐⭐⭐ | Navigation, reusability patterns, animations |
| ⭐⭐⭐⭐ | Full architecture — MVVM, API, DI, coroutines |

---

## 🗂️ Structure

```
master
├── feature/
│   ├── reusable-onboarding-compose         ⭐⭐⭐
│   ├── dictionary-app                      ⭐⭐⭐⭐
│   └── animated-chat-application           ⭐⭐⭐⭐
├── practice/
│   ├── text-practice                       ⭐
│   └── row-column                          ⭐
└── google-compose/
    ├── birthday-card                       ⭐
    ├── dice-roller-app                     ⭐⭐
    └── basic-tip-calculator                ⭐⭐
```

## 📖 Branch Details

### practice/ — Start here if you're new to Compose
- **text-practice** `⭐` — Text composable, font styles, sizes, weights, alignment, colour
- **row-column** `⭐` — Row & Column layouts, Arrangement, Alignment, Modifier.weight()

### google-compose/ — Build complete screens
- **birthday-card** `⭐` — Box layout, Image, painterResource, ContentScale, working with assets
- **dice-roller-app** `⭐⭐` — State with `remember` + `mutableStateOf`, Button onClick, dynamic image updates, recomposition
- **basic-tip-calculator** `⭐⭐` — TextField input, number formatting, state-driven UI, basic calculations

### feature/ — Real-world patterns
- **reusable-onboarding-compose** `⭐⭐⭐` — HorizontalPager, LaunchedEffect, state hoisting, reusable components, navigation, animated transitions
- **dictionary-app** `⭐⭐⭐⭐` — MVVM, Repository pattern, Hilt/Koin DI, Retrofit/Ktor, Coroutines, LazyColumn, error & loading states
- **animated-chat-application** `⭐⭐⭐⭐` — Complex animations, real-time UI updates, chat architecture, custom composables

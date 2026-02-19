# Branch Index

> A catalogue of all branches in this repo. Each branch is a self-contained Jetpack Compose project.
> Open this file on `master`, pick a branch, and run `git checkout branch-name`.

## 🗂️ Structure

```
master
├── feature/
│   ├── reusable-onboarding-compose         ⭐⭐⭐  Intermediate
│   ├── dictionary-app                      ⭐⭐⭐⭐ Advanced
│   └── animated-chat-application           ⭐⭐⭐⭐ Advanced
├── practice/
│   ├── text-practice                       ⭐     Beginner
│   └── row-column                          ⭐     Beginner
└── google-compose/
|   ├── birthday-card                       ⭐     Beginner
|   ├── dice-roller-app                     ⭐⭐    Beginner+
|   ├── basic-tip-calculator                ⭐⭐    Beginner+
|   └── art-space-app                       ⭐⭐    Beginner+
└── codelabs/
|   ├── basic-layouts                       ⭐⭐⭐  Intermediate
|   └── basic-state                         ⭐⭐⭐  Intermediate
```


## 📖 Branch Details

### practice/ — Start here if you're new to Compose
- **text-practice** `⭐ Beginner` — Text composable, font styles, sizes, weights, alignment, colour
- **row-column** `⭐ Beginner` — Row & Column layouts, Arrangement, Alignment, Modifier.weight()

### google-compose/ — Build complete screens
- **birthday-card** `⭐ Beginner` — Box layout, Image, painterResource, ContentScale, working with assets
- **dice-roller-app** `⭐⭐ Beginner+` — State with `remember` + `mutableStateOf`, Button onClick, dynamic image updates, recomposition
- **basic-tip-calculator** `⭐⭐ Beginner+` — TextField input, number formatting, state-driven UI, basic calculations
- **art-space-app** - `⭐⭐    Beginner+` — `data class` for artwork model, `remember`+ `mutableStateOf` for index tracking conditional button enable/disable, `buildAnnotatedString` with `SpanStyle`, `Card` with elevation, `ContentScale.Crop`, `LocalConfiguration` for responsive width

### feature/ — Real-world patterns
- **reusable-onboarding-compose** `⭐⭐⭐ Intermediate` — HorizontalPager, LaunchedEffect, state hoisting, reusable components, navigation, animated transitions
- **dictionary-app** `⭐⭐⭐⭐ Advanced` — MVVM, Repository pattern, Hilt/Koin DI, Retrofit/Ktor, Coroutines, LazyColumn, error & loading states
- **animated-chat-application** `⭐⭐⭐⭐ Advanced` — Complex animations, real-time UI updates, chat architecture, custom composables


### codelabs/ - 
- **basic-layouts** `⭐⭐⭐ Intermediate` — MySoothe wellness app with adaptive layouts using WindowSizeClass, LazyRow, LazyHorizontalGrid, NavigationBar vs NavigationRail for portrait/landscape, Scaffold, slot APIs with content: @Composable () -> Unit, paddingFromBaseline, circular image clipping with CircleShape
- **basic-state** `⭐⭐⭐ Intermediate` — Wellness tracker app with ViewModel integration via viewModel(), state hoisting pattern (stateless composables driven by parent state), rememberSaveable for config change survival, toMutableStateList() for observable list mutations, LazyColumn with item removal, separating UI state from business logic

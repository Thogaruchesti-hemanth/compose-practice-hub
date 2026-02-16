# State Management & Animation Fundamentals

## Overview
This branch demonstrates **core Jetpack Compose concepts** including state management, animation, lazy lists, and navigation patterns. It builds a practical onboarding flow with an expandable greeting list, showcasing how Compose handles reactive UI updates and smooth animations.

## What You'll Learn

### 1. **State Management Patterns**
- **`remember`** — Preserves state across recompositions (resets on configuration changes)
- **`rememberSaveable`** — Persists state across configuration changes and process death
- **`mutableStateOf`** — Creates an observable state that triggers recomposition when changed
- **`State hoisting`** — Moving the state up to make composables stateless and reusable

### 2. **Conditional Navigation**
Simple screen routing based on boolean state (`shouldShowOnboarding`) to switch between onboarding and main content without external navigation libraries.

### 3. **LazyColumn Performance**
- Efficient rendering of large lists (1000+ items) with `LazyColumn`
- Understanding the difference between `Column` (renders all children) and `LazyColumn` (renders only visible items)
- Using `items()` to iterate over collections

### 4. **Animation System**
- **`animateDpAsState`** — Animates dimension values with automatic interpolation
- **Spring animations** — Physics-based animations with configurable damping and stiffness
- **`coerceAtLeast()`** — Ensures animated values stay within valid bounds

### 5. **Edge-to-Edge UI**
- **`enableEdgeToEdge()`** — Modern Android UI that draws behind system bars
- **`safeDrawingPadding()`** — Automatically applies insets to avoid system UI overlap

### 6. **Callbacks & Event Handling**
Passing lambda functions (`onContinueClicked`) for parent-child communication without tight coupling.

## Key Takeaways

✓ **Stateful vs Stateless** — Distinguish between stateful composables (manage their own state) and stateless composables (receive state via parameters)

✓ **Recomposition Scope** — Only composables reading changed state will recompose, not the entire tree

✓ **Animation Best Practices** — Use spring animations for natural, physics-based motion; prefer `animateDpAsState` over manual animation logic

✓ **List Optimisation** — Always use `LazyColumn`/`LazyRow` for dynamic or large lists to maintain performance

✓ **Preview Strategies** — Use `@Preview` with different configurations (system UI, custom dimensions) for rapid UI iteration

✓ **Material 3 Theming** — Leverage `MaterialTheme.colorScheme` for consistent, themeable colours across the app

## Practical Applications
- Building onboarding flows with skip/complete logic
- Creating expandable/collapsible list items
- Implementing smooth transitions between UI states
- Handling large datasets efficiently with lazy loading
- Creating accessible, edge-to-edge modern Android UIs

## Architecture Patterns
- **Single Activity Architecture** — Using `ComponentActivity` with Compose
- **Composition over Inheritance** — Building complex UIs by combining simple composables
- **Unidirectional Data Flow** — State flows down, events flow up (callback pattern)

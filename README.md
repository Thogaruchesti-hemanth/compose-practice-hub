# Column Arrangements & Layout Fundamentals

## Overview
This branch explores **Jetpack Compose layout fundamentals**, specifically focusing on `Column` arrangements, spacing strategies, and vertical layout patterns. It serves as a practical reference for understanding how Compose handles vertical alignment and distribution of UI elements.

## What You'll Learn

### 1. **Vertical Arrangement Strategies**
- **SpaceAround** — Equal space above and below each child, with half-space at edges
- **SpaceBetween** — Maximum space between children, no space at edges
- **SpaceEvenly** — Equal space between all children and edges
- **Top** — Align children to the top of the container
- **Center** — Center children vertically within the container
- **Bottom** — Align children to the bottom of the container

### 2. **Horizontal Scrolling**
Implementation of horizontally scrollable content using `horizontalScroll()` modifier with `rememberScrollState()`.

### 3. **Vertical Scrolling**
Creating scrollable vertical lists with `verticalScroll()` for content that exceeds screen height.

### 4. **Dynamic Sizing Patterns**
Working with fixed heights, `fillMaxWidth()`, and `fillMaxSize()` modifiers to create responsive layouts.

### 5. **Component Composition**
Building reusable composable functions (`ArrangementDemo`, `DemoBox`, `DemoBoxTwo`) that accept parameters for flexible UI creation.

## Key Takeaways

✓ **Arrangement vs Alignment** — Understand the difference between vertical arrangement (spacing) and horizontal alignment (positioning)

✓ **Visual Debugging** — Use background colors and borders to visualize layout boundaries and spacing behavior

✓ **Scrollable Containers** — Implement both horizontal and vertical scrolling when content exceeds viewport

✓ **Spacing Techniques** — Choose between `Arrangement.spacedBy()` for consistent gaps vs. different arrangement strategies for dynamic spacing

✓ **Modifier Chaining** — Proper order of modifiers matters: size → padding → background → scroll

## Practical Applications
- Creating evenly distributed navigation menus
- Building scrollable content feeds with consistent spacing
- Designing comparison views (like the arrangement demo carousel)
- Implementing flexible layout systems that adapt to content size

# BRANCH_INDEX

> **Complete catalog of all UI implementations in this repository**  
> Each branch is a self-contained example you can explore, learn from, and use in your projects.

## 📑 Table of Contents
- [How to Use This Index](#how-to-use-this-index)
- [Beginner Level](#-beginner-level)
- [Intermediate Level](#-intermediate-level)
- [Advanced Level](#-advanced-level)
- [Feature Implementations](#-feature-implementations)
- [Quick Reference](#-quick-reference)

---

## How to Use This Index

Each entry includes:
- 🎯 **Learning Objectives**: What you'll learn
- 📱 **UI Components**: Key Compose components used
- ⏱️ **Estimated Time**: How long to understand and practice
- 🔗 **Branch Name**: Direct link to checkout
- 📸 **Preview**: Visual representation

**To explore a branch:**
```bash
git checkout branch-name
```

---

## 🌱 Beginner Level
*Perfect for those just starting with Jetpack Compose*

### 1. Text Practice
**Branch:** `practice/text-practice`  
**Difficulty:** ⭐ Beginner  
**Time:** 15-20 minutes

<img src="https://github.com/user-attachments/assets/c8ed823c-1a0d-40e5-8cc0-3253b58b49cf" width="200"/>

🎯 **What You'll Learn:**
- Text composable fundamentals
- Font styles, sizes, and weights
- Text alignment and formatting
- Color application
- Basic text modifiers

📱 **Key Components:**
- `Text()`
- `fontWeight`, `fontSize`, `fontFamily`
- `textAlign`, `color`, `style`

💡 **Best For:**
- Understanding basic composables
- Typography in Material Design
- Your first Compose screen

```bash
git checkout practice/text-practice
```

---

### 2. Row & Column Layouts
**Branch:** `practice/row-column`  
**Difficulty:** ⭐ Beginner  
**Time:** 30-45 minutes

<img src="https://github.com/user-attachments/assets/261549a2-72e9-4c25-aa5f-f34edd95bbda" width="200"/>
<img src="https://github.com/user-attachments/assets/f8b0f410-bb70-44c7-85fa-8b35c544db68" width="200"/>

🎯 **What You'll Learn:**
- Horizontal layouts with Row
- Vertical layouts with Column
- Arrangement patterns (SpaceBetween, SpaceAround, SpaceEvenly)
- Alignment options (Start, Center, End)
- Nesting layouts effectively

📱 **Key Components:**
- `Row()`, `Column()`
- `Arrangement` modifiers
- `Alignment` properties
- `Modifier.weight()`, `Modifier.padding()`

💡 **Best For:**
- Understanding Compose layout system
- Building structured UIs
- Replacing LinearLayout from XML

```bash
git checkout practice/row-column
```

---

### 3. Birthday Card
**Branch:** `google-compose/birthday-card`  
**Difficulty:** ⭐ Beginner  
**Time:** 45-60 minutes

<img src="https://github.com/user-attachments/assets/50da08ce-0d8d-4941-ad0c-888538072784" width="200"/>

🎯 **What You'll Learn:**
- Combining text and images
- Working with resources (strings, drawables)
- Box layout for layering
- Basic Material Design patterns
- Creating a complete screen

📱 **Key Components:**
- `Box()`, `Image()`, `Text()`
- `painterResource()`
- `ContentScale`
- `Modifier.fillMaxSize()`, `padding()`

💡 **Best For:**
- Your first complete UI
- Understanding layered layouts
- Working with assets

```bash
git checkout google-compose/birthday-card
```

---

### 4. Business Card
**Branch:** `google-compose/business-card`  
**Difficulty:** ⭐⭐ Beginner-Intermediate  
**Time:** 1-1.5 hours

<img src="https://github.com/user-attachments/assets/99ab4c8b-eccf-4c5c-8902-1217d7bffa61" width="200"/>

🎯 **What You'll Learn:**
- Creating professional layouts
- Icons integration
- Dividers and spacing
- Contact information display
- Material Design cards

📱 **Key Components:**
- `Icon()`, `Card()`
- `Divider()`
- `Spacer()`
- Material3 theming

💡 **Best For:**
- Building portfolio apps
- Professional UI design
- Understanding Material3 components

```bash
git checkout google-compose/business-card
```

---

## 🚀 Intermediate Level
*Build on fundamentals with interactive UIs and state management*

### 5. Dice Roller App
**Branch:** `feature/dice-roller-app`  
**Difficulty:** ⭐⭐ Intermediate  
**Time:** 1.5-2 hours

<img src="https://github.com/user-attachments/assets/011277f8-33b8-4584-bf3b-d635a545070f" width="200"/>

🎯 **What You'll Learn:**
- State management with `remember` and `mutableStateOf`
- Button interactions and onClick events
- Dynamic image updates
- Random number generation
- Recomposition understanding

📱 **Key Components:**
- `Button()`, `Image()`
- `remember`, `mutableStateOf`
- `when` expressions for state handling

💡 **Best For:**
- Understanding state in Compose
- Interactive UI basics
- Your first stateful app

🔧 **Code Highlights:**
```kotlin
var diceResult by remember { mutableStateOf(1) }
Button(onClick = { diceResult = (1..6).random() })
```

```bash
git checkout feature/dice-roller-app
```

---

### 6. Reusable Onboarding Screen
**Branch:** `feature/reusable-onboarding-compose`  
**Difficulty:** ⭐⭐⭐ Intermediate  
**Time:** 2-3 hours

<img src="https://github.com/user-attachments/assets/5a32d748-5a05-4ed2-bafd-9d1619212560" width="200"/>

🎯 **What You'll Learn:**
- Creating reusable components
- Pager implementation with HorizontalPager
- Page indicators
- Navigation between screens
- State hoisting patterns
- Animated transitions

📱 **Key Components:**
- `HorizontalPager()`, `PagerState`
- `LaunchedEffect()`
- Custom composable functions
- Navigation component

💡 **Best For:**
- Building app introduction flows
- Understanding component reusability
- Advanced state management
- Production-ready patterns

🔧 **Features:**
- Skip functionality
- Smooth page transitions
- Customizable content
- Progress indicators

```bash
git checkout feature/reusable-onboarding-compose
```

---

## 🎓 Advanced Level
*Complex UIs with real-world application patterns*

### 7. Dictionary App
**Branch:** `feature/dictionary-app`  
**Difficulty:** ⭐⭐⭐⭐ Advanced  
**Time:** 4-6 hours

<img src="https://github.com/user-attachments/assets/0dd43785-841f-48d0-b932-4e52983b1c5d" width="200"/>

🎯 **What You'll Learn:**
- MVVM architecture in Compose
- API integration and data fetching
- Search functionality implementation
- LazyColumn for efficient lists
- Error handling and loading states
- Retrofit/Ktor integration
- Repository pattern
- Coroutines and async operations

📱 **Key Components:**
- `LazyColumn()`, `TextField()`
- `ViewModel`, `StateFlow`
- `remember`, `collectAsState()`
- Network layer integration
- Data classes and models

💡 **Best For:**
- Understanding production architecture
- API consumption in Compose
- Real-world app development
- Job interview preparation

🔧 **Technical Stack:**
- Clean Architecture
- Dependency Injection (Hilt/Koin)
- Coroutines
- Material3 components
- Error handling

```bash
git checkout feature/dictionary-app
```

---

## 🎨 Feature Implementations
*Specific UI patterns and components you can copy-paste*

### Coming Soon

#### 📝 Form Validation
- Input fields with validation
- Error states
- Submit functionality

#### 🌙 Dark Mode Toggle
- Theme switching
- Persistent preferences
- Material3 theming

#### 📊 Charts & Graphs
- Custom Canvas drawing
- Data visualization
- Interactive charts

#### 🎭 Animation Showcase
- Enter/exit animations
- Shared element transitions
- Complex animations

#### 🎵 Music Player UI
- Media controls
- Progress bars
- Custom sliders

---

## 📊 Quick Reference

### By Component Type

| Component | Branches |
|-----------|----------|
| Text | `practice/text-practice`, `google-compose/birthday-card` |
| Layouts | `practice/row-column`, all branches |
| Images | `google-compose/birthday-card`, `feature/dice-roller-app` |
| Buttons | `feature/dice-roller-app`, `feature/reusable-onboarding-compose` |
| Lists | `feature/dictionary-app` |
| Navigation | `feature/reusable-onboarding-compose`, `feature/dictionary-app` |
| State Management | `feature/dice-roller-app`, `feature/dictionary-app` |
| API Integration | `feature/dictionary-app` |

### By Learning Path

**Day 1-2: Compose Basics**
1. `practice/text-practice`
2. `practice/row-column`
3. `google-compose/birthday-card`

**Day 3-4: Interactive UIs**
1. `google-compose/business-card`
2. `feature/dice-roller-app`

**Week 2: Advanced Patterns**
1. `feature/reusable-onboarding-compose`
2. `feature/dictionary-app`

### By Time Available

**15-30 minutes**: `practice/text-practice`  
**1 hour**: `google-compose/birthday-card`, `google-compose/business-card`  
**2-3 hours**: `feature/dice-roller-app`, `feature/reusable-onboarding-compose`  
**Half day**: `feature/dictionary-app`

---

## 🎯 Skill Matrix

| Branch | Layouts | State | Navigation | API | Animation | Difficulty |
|--------|---------|-------|------------|-----|-----------|------------|
| text-practice | ✅ | ❌ | ❌ | ❌ | ❌ | ⭐ |
| row-column | ✅✅ | ❌ | ❌ | ❌ | ❌ | ⭐ |
| birthday-card | ✅✅ | ❌ | ❌ | ❌ | ❌ | ⭐ |
| business-card | ✅✅✅ | ❌ | ❌ | ❌ | ❌ | ⭐⭐ |
| dice-roller-app | ✅✅ | ✅✅ | ❌ | ❌ | ❌ | ⭐⭐ |
| reusable-onboarding | ✅✅✅ | ✅✅ | ✅✅ | ❌ | ✅✅ | ⭐⭐⭐ |
| dictionary-app | ✅✅✅ | ✅✅✅ | ✅✅ | ✅✅✅ | ✅ | ⭐⭐⭐⭐ |

---

## 💡 Tips for Using This Index

1. **Start Simple**: Begin with ⭐ branches even if you're experienced
2. **Build Up**: Follow the recommended learning paths
3. **Mix & Match**: Combine concepts from different branches
4. **Contribute**: Add your own branches and update this index
5. **Ask Questions**: Use GitHub Discussions for help

---

<div align="center">

**Find what you need, learn at your pace, build amazing UIs! 🚀**

[⬆ Back to Top](#branchindexmd)  
[📖 Main README](README.md)

</div>

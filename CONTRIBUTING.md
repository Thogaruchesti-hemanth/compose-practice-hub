# Contributing to Compose UI Playground

First off, thank you for considering contributing to Compose UI Playground! 🎉

This repository thrives because of contributors like you who want to help others learn Jetpack Compose. Whether you're adding a new UI implementation, fixing bugs, improving documentation, or suggesting ideas, your contribution is valuable.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Getting Started](#getting-started)
- [Branch Naming Convention](#branch-naming-convention)
- [Creating a New UI Branch](#creating-a-new-ui-branch)
- [Code Guidelines](#code-guidelines)
- [Documentation Standards](#documentation-standards)
- [Pull Request Process](#pull-request-process)
- [Review Process](#review-process)
- [Community](#community)

## 📜 Code of Conduct

This project adheres to a Code of Conduct that all contributors are expected to follow. By participating, you agree to:

- Be respectful and inclusive
- Welcome newcomers and help them learn
- Accept constructive criticism gracefully
- Focus on what's best for the community
- Show empathy towards other contributors

**Unacceptable behavior includes:**
- Harassment, discrimination, or offensive comments
- Trolling or insulting remarks
- Publishing others' private information
- Any conduct that would be inappropriate in a professional setting

## 🤝 How Can I Contribute?

### 1. Adding New UI Implementations ⭐

This is the primary way to contribute! Create a new branch with a unique Compose UI implementation.

**Good UI Topics:**
- Login/Signup screens
- Profile pages
- Product cards
- Custom dialogs
- Navigation patterns
- Animation effects
- Form validations
- Data visualization
- Loading states
- Empty states
- Error handling UIs
- Onboarding flows
- Settings screens
- Search interfaces

### 2. Improving Existing UIs 🔧

- Enhance code quality
- Add missing features
- Optimize performance
- Improve accessibility
- Update to latest Compose APIs
- Add more comments

### 3. Documentation 📝

- Fix typos or unclear explanations
- Add more examples
- Translate documentation
- Create video tutorials
- Write blog posts about the UIs

### 4. Bug Fixes 🐛

- Report bugs you find
- Fix reported issues
- Improve error handling
- Add edge case handling

### 5. Suggestions & Ideas 💡

- Propose new UI implementations
- Suggest improvements to existing code
- Share best practices
- Discuss architecture patterns

## 🚀 Getting Started

### Prerequisites

- **Git** installed on your machine
- **Android Studio** (Hedgehog 2023.1.1 or later)
- **JDK 17** or higher
- **GitHub account**
- Basic knowledge of **Kotlin** and **Jetpack Compose**

### Fork & Clone

1. **Fork this repository** by clicking the "Fork" button at the top right

2. **Clone your fork**
   ```bash
   git clone https://github.com/YOUR_USERNAME/compose-ui-playground.git
   cd compose-ui-playground
   ```

3. **Add upstream remote**
   ```bash
   git remote add upstream https://github.com/ORIGINAL_OWNER/compose-ui-playground.git
   ```

4. **Verify remotes**
   ```bash
   git remote -v
   # origin    https://github.com/YOUR_USERNAME/compose-ui-playground.git (fetch)
   # origin    https://github.com/YOUR_USERNAME/compose-ui-playground.git (push)
   # upstream  https://github.com/ORIGINAL_OWNER/compose-ui-playground.git (fetch)
   # upstream  https://github.com/ORIGINAL_OWNER/compose-ui-playground.git (push)
   ```

### Keep Your Fork Updated

Before creating a new branch, always sync with upstream:

```bash
git checkout main
git fetch upstream
git merge upstream/main
git push origin main
```

## 🌿 Branch Naming Convention

All UI implementation branches should follow this pattern:

```
ui/<descriptive-name>
```

**Examples:**
- `ui/login-screen`
- `ui/animated-bottom-sheet`
- `ui/parallax-card`
- `ui/custom-switch`
- `ui/glassmorphism-card`

**For non-UI contributions:**
- `fix/bug-description` - Bug fixes
- `docs/improvement-description` - Documentation updates
- `refactor/component-name` - Code refactoring

## 🎨 Creating a New UI Branch

### Step 1: Plan Your UI

Before coding, consider:

- **Is it unique?** Check existing branches to avoid duplicates
- **Learning value?** Does it teach something useful?
- **Complexity level?** Beginner, Intermediate, or Advanced?
- **Real-world use?** Is it practical for actual apps?

### Step 2: Create Your Branch

```bash
# Make sure you're on main and it's up to date
git checkout main
git pull upstream main

# Create your new UI branch
git checkout -b ui/your-ui-name
```

### Step 3: Set Up Your UI

Create a clean project structure:

```
compose-ui-playground/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/yourpackage/
│           │   ├── MainActivity.kt
│           │   ├── ui/
│           │   │   └── YourUIScreen.kt
│           │   ├── components/
│           │   │   └── CustomComponents.kt
│           │   └── theme/
│           │       ├── Color.kt
│           │       ├── Theme.kt
│           │       └── Type.kt
│           └── res/
│               ├── drawable/
│               └── values/
└── README.md (Branch-specific)
```

### Step 4: Implement Your UI

Follow the [Code Guidelines](#code-guidelines) section below.

### Step 5: Create Branch README

Each UI branch must have its own README with:

```markdown
# [UI Name]

## 📱 Preview
[Add screenshots or GIF here]

## 🎯 Learning Objectives
- What developers will learn from this UI
- Key Compose concepts demonstrated
- Best practices highlighted

## ⚙️ Key Features
- List of features implemented
- Special animations or interactions
- Accessibility features

## 🏗️ Architecture
Brief explanation of code structure

## 🔧 Key Components
- `ComponentName` - Brief description
- `AnotherComponent` - Brief description

## 📚 Concepts Covered
- Compose concept 1
- Compose concept 2
- Material Design principle

## 🎓 Difficulty Level
**[Beginner/Intermediate/Advanced]**

## 💡 Usage Tips
How to customize or extend this UI

## 🔗 Resources
- Links to relevant documentation
- Related tutorials
- Design inspiration source
```

### Step 6: Test Thoroughly

- ✅ Test on different screen sizes
- ✅ Test in light and dark modes
- ✅ Test with different font sizes
- ✅ Check accessibility (TalkBack)
- ✅ Verify no crashes or ANRs
- ✅ Test with different Android versions (min API 21+)

### Step 7: Commit Your Changes

```bash
git add .
git commit -m "Add [UI Name] implementation

- Implemented [key feature 1]
- Added [key feature 2]
- Includes README and screenshots"
```

### Step 8: Push to Your Fork

```bash
git push origin ui/your-ui-name
```

## 📋 Code Guidelines

### General Principles

1. **Clean Code**: Write code that others can easily understand
2. **Comments**: Explain the "why", not just the "what"
3. **Compose Best Practices**: Follow official Compose guidelines
4. **Material Design**: Adhere to Material Design principles
5. **Performance**: Avoid unnecessary recompositions

### Kotlin Style

Follow the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html):

```kotlin
// ✅ Good
@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // UI implementation
    }
}

// ❌ Avoid
@Composable
fun loginscreen(onLoginClick:(String,String)->Unit,modifier: Modifier=Modifier){
    var email=remember{mutableStateOf("")}
    // Poor formatting and naming
}
```

### Compose Best Practices

#### State Management

```kotlin
// ✅ Good - Hoist state when needed
@Composable
fun ParentScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    
    ChildComponent(
        selectedTab = selectedTab,
        onTabSelected = { selectedTab = it }
    )
}

// ❌ Avoid - Unnecessary state in child
@Composable
fun ChildComponent() {
    var selectedTab by remember { mutableStateOf(0) }
    // State that should be hoisted
}
```

#### Naming Conventions

```kotlin
// ✅ Good
@Composable
fun ProfileCard(user: User, modifier: Modifier = Modifier)

@Composable
fun AnimatedButton(onClick: () -> Unit, modifier: Modifier = Modifier)

// ❌ Avoid
@Composable
fun profile_card(user: User)  // Wrong naming

@Composable
fun Button2(onClick: () -> Unit)  // Non-descriptive
```

#### Modifiers

```kotlin
// ✅ Good - Modifier parameter last with default
@Composable
fun CustomCard(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier  // Apply passed modifier first
            .fillMaxWidth()
            .padding(16.dp)
    ) { /* ... */ }
}

// ❌ Avoid - Modifier not customizable
@Composable
fun CustomCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()  // Hardcoded
    ) { /* ... */ }
}
```

### Comments and Documentation

```kotlin
/**
 * A custom animated button that scales on press and shows a loading state.
 * 
 * This component demonstrates:
 * - AnimatedVisibility for loading state
 * - Scale animation on interaction
 * - Custom color transitions
 * 
 * @param text The button text to display
 * @param isLoading Whether to show loading indicator
 * @param onClick Callback when button is clicked
 * @param modifier Modifier to be applied to the button
 */
@Composable
fun AnimatedButton(
    text: String,
    isLoading: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Implementation with inline comments for complex logic
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        label = "Button scale animation"
    )
    
    // Rest of implementation
}
```

### Performance Considerations

```kotlin
// ✅ Good - Stable parameters
@Composable
fun ItemList(items: List<Item>) {
    LazyColumn {
        items(
            items = items,
            key = { it.id }  // Stable key for better performance
        ) { item ->
            ItemCard(item)
        }
    }
}

// ✅ Good - Remember expensive calculations
@Composable
fun ComplexUI() {
    val expensiveResult = remember(dependency) {
        performExpensiveCalculation()
    }
}

// ❌ Avoid - Creating new lambdas in loops
LazyColumn {
    items(list) { item ->
        Button(onClick = { /* inline lambda */ })  // Creates new lambda each time
    }
}
```

### Accessibility

Always consider accessibility:

```kotlin
@Composable
fun AccessibleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.semantics {
            contentDescription = "Submit button"
            role = Role.Button
        }
    ) {
        Text(text)
    }
}
```

## 📝 Documentation Standards

### Branch README Requirements

Every UI branch must include:

1. **Visual Preview**: Screenshots or GIF (< 10MB)
2. **Learning Objectives**: Clear list of what learners will gain
3. **Features**: What the UI does
4. **Difficulty Level**: Beginner/Intermediate/Advanced
5. **Key Components**: Main composables used
6. **Concepts Covered**: Compose principles demonstrated
7. **Usage Instructions**: How to run and customize

### Screenshot Guidelines

- **Format**: PNG for static images, GIF for animations
- **Size**: Mobile device screenshots (portrait preferred)
- **Quality**: High resolution, clear and readable
- **Background**: Use light mode by default, include dark mode if different
- **Location**: Store in `screenshots/` folder in your branch

### Code Comments

```kotlin
// Single-line comments for simple explanations

/**
 * Multi-line comments for:
 * - Component documentation
 * - Complex algorithms
 * - Important business logic
 * - API documentation
 */

// TODO: Future improvement needed
// FIXME: Known issue to be resolved
// NOTE: Important information
```

## 🔄 Pull Request Process

### Before Submitting

- [ ] Code compiles without errors
- [ ] UI tested on multiple screen sizes
- [ ] Dark mode tested (if applicable)
- [ ] No hardcoded strings (use string resources)
- [ ] Branch README created with screenshots
- [ ] Code follows style guidelines
- [ ] Comments added for complex logic
- [ ] No sensitive data or API keys in code

### Creating a Pull Request

1. **Go to your fork** on GitHub
2. **Click "Pull Request"** button
3. **Select branches**:
   - Base: `original-repo/main`
   - Compare: `your-fork/ui/your-ui-name`
4. **Fill out the PR template**

### PR Title Format

```
Add [UI Name] - [Brief Description]
```

**Examples:**
- `Add Animated Login Screen - Material Design 3`
- `Add Parallax Card - Advanced Scrolling Effects`
- `Fix Dark Mode Issues in Profile Screen`

### PR Description Template

```markdown
## 🎨 UI Implementation

**UI Name:** [Your UI Name]
**Difficulty:** [Beginner/Intermediate/Advanced]
**Branch:** `ui/your-ui-name`

## 📸 Screenshots

[Add screenshots or GIF here]

## 🎯 What This UI Teaches

- Learning point 1
- Learning point 2
- Learning point 3

## ✨ Key Features

- Feature 1
- Feature 2
- Feature 3

## 🔧 Implementation Details

Brief explanation of approach, challenges overcome, or special techniques used.

## 📚 Concepts Demonstrated

- [ ] State management
- [ ] Animations
- [ ] Custom components
- [ ] Material Design
- [ ] Navigation
- [ ] Accessibility
- [ ] Performance optimization

## ✅ Checklist

- [ ] Code compiles and runs
- [ ] Tested on multiple screen sizes
- [ ] Dark mode support tested
- [ ] Branch README included
- [ ] Screenshots added
- [ ] Code commented
- [ ] Follows contribution guidelines

## 💬 Additional Notes

Any additional context, resources, or information reviewers should know.
```

### After Submitting

- Respond to review comments promptly
- Make requested changes in your branch
- Push updates (they'll automatically appear in the PR)
- Be patient and respectful during review

## 👀 Review Process

### What Reviewers Look For

**Code Quality:**
- Follows Kotlin and Compose best practices
- Readable and maintainable
- Properly commented
- No obvious bugs or issues

**Learning Value:**
- Teaches useful Compose concepts
- Demonstrates best practices
- Appropriate for stated difficulty level
- Has real-world applicability

**Documentation:**
- Clear README with all required sections
- Quality screenshots/GIF
- Helpful comments in code
- Accurate learning objectives

**Technical:**
- Compiles without errors
- Works on different screen sizes
- Handles edge cases
- Good performance (no lag or crashes)

### Review Timeline

- Initial review: Within 3-5 days
- Follow-up reviews: Within 2-3 days
- Merge decision: After approval from maintainers

### Addressing Review Feedback

```bash
# Make changes based on feedback
git add .
git commit -m "Address review feedback: [description]"
git push origin ui/your-ui-name
```

The PR will automatically update with your changes.

## 🎓 Tips for Great Contributions

### For First-Time Contributors

1. **Start Small**: Begin with a beginner-level UI
2. **Study Examples**: Look at existing branches for inspiration
3. **Ask Questions**: Use discussions or issues if unsure
4. **Learn from Reviews**: Feedback helps you grow
5. **Don't Rush**: Quality over speed

### For Experienced Contributors

1. **Push Boundaries**: Create advanced, unique UIs
2. **Share Knowledge**: Add detailed explanations
3. **Mentor Others**: Help review PRs from newcomers
4. **Optimize**: Show performance best practices
5. **Innovate**: Experiment with new Compose features

### Making Your UI Stand Out

- **Unique Concept**: Choose something not already implemented
- **Beautiful Design**: Follow Material Design principles
- **Smooth Animations**: Make it feel polished
- **Well Documented**: Explain everything clearly
- **Production Ready**: Write code people can actually use
- **Accessibility**: Make it usable for everyone

## 🐛 Reporting Bugs

### Before Reporting

- Check if the issue already exists
- Test on latest code from `main`
- Gather reproduction steps

### Bug Report Template

**Title:** `[Bug] Brief description`

```markdown
## 🐛 Bug Description
Clear description of what's wrong

## 📱 Environment
- Android Studio version:
- Kotlin version:
- Device/Emulator:
- Android version:

## 🔄 Steps to Reproduce
1. Step one
2. Step two
3. Step three

## ✅ Expected Behavior
What should happen

## ❌ Actual Behavior
What actually happens

## 📸 Screenshots
If applicable

## 💡 Possible Solution
If you have ideas
```

## 💡 Suggesting Enhancements

We love new ideas! To suggest an enhancement:

1. **Open an Issue** with tag `enhancement`
2. **Describe the Idea** clearly
3. **Explain the Value** - why it would help learners
4. **Show Examples** - mockups or references if available

## 🏆 Recognition

Contributors are the heart of this project! We recognize contributions through:

- **Contributors List**: Added to README
- **Branch Attribution**: Your name in branch README
- **Special Thanks**: Highlighted in release notes
- **Community Shoutouts**: Featured on social media

## 📞 Getting Help

**Stuck? Need guidance?**

- 💬 [Discussions](https://github.com/yourusername/compose-ui-playground/discussions) - Ask questions
- 🐛 [Issues](https://github.com/yourusername/compose-ui-playground/issues) - Report problems
- 📧 Email: your-email@example.com
- 🐦 Twitter: [@yourusername](https://twitter.com/yourusername)

## 📚 Additional Resources

- [Jetpack Compose Guidelines](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Style Guide](https://kotlinlang.org/docs/coding-conventions.html)
- [Android Accessibility](https://developer.android.com/guide/topics/ui/accessibility)

## 🙏 Thank You!

Your contributions make this resource valuable for developers worldwide. Whether you're fixing a typo or creating an elaborate UI, every contribution matters.

**Happy Contributing! 🚀**

---

<div align="center">

**Questions?** Open an [issue](https://github.com/yourusername/compose-ui-playground/issues) or start a [discussion](https://github.com/yourusername/compose-ui-playground/discussions)

[⬆ Back to Top](#contributing-to-compose-ui-playground)

</div>

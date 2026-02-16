# Text Styling & Typography Practice

This branch demonstrates comprehensive text styling capabilities in Jetpack Compose through three practice screens that progressively build your understanding of text rendering, styling, and layout integration.

## What's Inside

Three practice screens showcasing different aspects of text rendering and styling:

- **TextPracticeScreenOne**: Font weights, spacing, decorations, baseline alignment, annotated strings, overflow handling
- **TextPracticeScreenTwo**: Similar concepts with variations in letter spacing and text decoration combinations
- **TextPracticeScreenThree**: Material3 typography system, text alignment, colour emphasis, layout integration

## Compose Concepts Covered

### 1. Text Composable
The foundational building block for displaying text in Jetpack Compose. Every screen demonstrates how different parameters transform basic text into styled content.

### 2. Typography System
Integration with Material3's type scale using `AppTypography` to access predefined text styles (`displayMedium`, `headlineMedium`, `bodySmall`). Maintains visual hierarchy and consistency across your app.

### 3. Font Weight
Complete spectrum of text thickness from `FontWeight.Thin` to `FontWeight.Black`. Includes: Thin, Light, Normal, Medium, SemiBold, Bold, ExtraBold, and Black.

### 4. Letter Spacing
Character spacing control using scalable pixel (`.sp`) units. Demonstrates both expanded spacing (positive values) and condensed spacing (negative values).

### 5. Text Decoration
Visual embellishments including underlines, strikethroughs, and combined decorations using `TextDecoration.combine()`. Useful for pricing, emphasis, and deprecated content.

### 6. AnnotatedString
Advanced inline text styling using `buildAnnotatedString` and `withStyle`. Enables multiple visual styles within a single text block without breaking it into separate composables.

### 7. BaselineShift
Vertical text alignment technique for positioning text of different sizes on the same baseline. Essential for subscript, superscript, and mixed-size text arrangements.

### 8. Text Alignment
Horizontal positioning control with `TextAlign`: Start (left), Center, End (right). Works in conjunction with `fillMaxWidth()` modifier.

### 9. Overflow Handling
Content truncation strategies using `maxLines` and `TextOverflow.Ellipsis`. Prevents layout breaking when text exceeds available space.

### 10. SpanStyle
Granular styling for text segments within AnnotatedStrings. Supports color, fontWeight, fontSize, background, fontStyle, and fontFamily properties.

### 11. Font Families
Typography variety using system fonts: `FontFamily.Default`, `FontFamily.Monospace`, and `FontFamily.Serif`. Creates visual distinction for different content types.

### 12. Font Style
Typographic emphasis using `FontStyle.Italic` and `FontStyle.Normal`. Commonly used for quotations, technical terms, or subtle emphasis.

### 13. Layout Integration
Text composables working within layout containers (`Column`, `Row`) with spacing controls (`Spacer`, `Arrangement.SpaceBetween`) and size modifiers (`fillMaxWidth()`, `padding()`).

### 14. Color Application
Text coloring at both composable level (entire text) and span level (inline segments). Demonstrates semantic colors for states like error, subtle, and emphasis.

### 15. Custom Components
Reusable text components (`TitleText`, `AddSpace`) that encapsulate common patterns, promoting consistency and maintainability across screens.

## Learning Path

This branch follows a progressive learning structure:

**Screens One & Two** focus on fundamental text properties and inline styling techniques. You'll understand how individual properties affect text appearance and how to combine multiple styles within single text blocks.

**Screen Three** demonstrates real-world application by integrating text with Material3's design system, showing how typography choices create visual hierarchy and improve user experience.

## Practical Applications

These concepts form the foundation for building:

- Product cards with mixed typography and pricing
- Form labels with validation messages
- Rich text content with inline formatting
- Data displays with aligned label-value pairs
- Error states and status indicators
- Hierarchical content structures

## Key Takeaways

Text rendering in Jetpack Compose offers fine-grained control at every level. You can style entire text blocks with direct parameters or create sophisticated inline formatting with AnnotatedString. The Material3 typography system provides consistency out of the box, while individual properties allow unlimited customization. Mastering these fundamentals enables you to implement any text-based design specification with precision and confidence.

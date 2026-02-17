# Compose Dictionary App

A production-ready Jetpack Compose dictionary screen that fetches and displays word definitions, phonetics, synonyms, antonyms, and examples. Built to be dropped into any app that needs a search-driven detail UI.

## Usage

Pass your `DictionaryViewModel` into the screen. The ViewModel handles the API call and exposes `wordData` as observable state.

```kotlin
DictionaryScreen(viewModel = viewModel())
```

Wire up `DictionaryViewModel.searchWord(query)` to your dictionary API (e.g. [Free Dictionary API](https://dictionaryapi.dev/)) and expose the result as a `StateFlow` or `mutableStateOf`.

## Structure

```
ui/
└── DictionaryScreen.kt     # Full screen composable + RoundedCard component

viewmodel/
└── DictionaryViewModel.kt  # Holds wordData state, calls searchWord()
```

## What You Can Learn From This

- **`RoundedCard` as a slot composable** — accepts `content: @Composable ColumnScope.() -> Unit`, making it a reusable card wrapper you can fill with anything
- **Conditional UI rendering** — synonyms, antonyms, and example sections only appear when data is available, using `isNullOrEmpty()` and `isNullOrBlank()` guards
- **`OutlinedTextFieldDefaults. colours ()`** — how to fully customise a text field's border, container, and text colours to match a custom design
- **`ViewModel` as the single source of truth** — search input lives in local `remember` state, but the result lives in the ViewModel, so it survives recomposition
- **`Scaffold` + `TopAppBar`** with custom container colour to build a branded app bar
- **`ColumnScope` receiver on content lambdas** — how to constrain slot API content to a specific layout scope

## Where You Can Use This

- Any app that needs a search → result detail pattern (dictionary, recipe, product lookup)
- A starting point for any API-backed search screen
- Replace the dictionary API with your own backend and reuse the entire layout

## Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit
- [Compose State](https://developer.android.com/jetpack/compose/state) - `remember`, `mutableStateOf`, ViewModel state
- [Compose Layout](https://developer.android.com/jetpack/compose/layouts) - `Column`, `Row`, `Scaffold`, `Card`
- [Material3](https://developer.android.com/jetpack/compose/designsystems/material3) - `TopAppBar`, `OutlinedTextField`, `Card`, `CardDefaults`
- [ViewModel](https://developer.android.com/jetpack/compose/state#viewmodels-as-state-owners) - state ownership and API call management
See the License for the specific language governing permissions and
limitations under the License.
```

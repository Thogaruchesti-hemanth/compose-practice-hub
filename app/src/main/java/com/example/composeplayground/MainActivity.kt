package com.example.composeplayground

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.MySootheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheApp()
        }
    }
}


// Step: Search bar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(
                text = stringResource(R.string.placeholder_search)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(text),
            modifier = modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    // Implement composable here
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .width(220.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(56.dp)
            )
            Text(
                stringResource(text),
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(items = alignYourBodyData){item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .height(120.dp)
    ) {
        items(items = favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text
            )
        }
    }

}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit

) {
    // Implement composable here
    Column(modifier) {
        Text(
            stringResource(title).uppercase(),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 8.dp,
                )
                .padding(horizontal = 16.dp)

        )
        content()
    }
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implement composable here
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    val items = listOf("Home", "Search", "Profile")
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, label ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                label = { Text(label) },
                icon = {
                    when (label) {
                        "Home" -> Icon(Icons.Default.Home, contentDescription = null)
                        "Search" -> Icon(Icons.Default.Search, contentDescription = null)
                        else -> Icon(Icons.Default.Person, contentDescription = null)
                    }
                }
            )
        }
    }
}


// Step: MySoothe App - Scaffold
@Composable
fun MySootheAppPortrait() {
    // Implement composable here
    Surface(
        color = MaterialTheme.colorScheme.background
    ) { }
    HomeScreen()
}

// Step: Bottom navigation - Material
@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    val items = listOf("Home", "Search", "Profile")
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationRail(
        modifier = modifier
    ) {
        items.forEachIndexed { index, label ->
            NavigationRailItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                icon = {
                    when (label) {
                        "Home" -> Icon(Icons.Default.Home, contentDescription = null)
                        "Search" -> Icon(Icons.Default.Search, contentDescription = null)
                        else -> Icon(Icons.Default.Person, contentDescription = null)
                    }
                },
                label = { Text(label) }
            )
        }
    }
}


// Step: Landscape Mode
@Composable
fun MySootheAppLandscape(){
    // Implement composable here
    Surface {
        HomeScreen()
    }
}

// Step: MySoothe App
@Composable
fun MySootheApp() {
    Scaffold(
        bottomBar = { SootheBottomNavigation(Modifier) }
    ) {innerPadding ->
        HomeScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @param:DrawableRes val drawable: Int,
    @param:StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        AlignYourBodyElement(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            drawable = R.drawable.fc2_nature_meditations,
            text = R.string.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview() {
    MySootheTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
    MySootheTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    MySootheTheme { HomeSection(title = R.string.align_your_body) {
        AlignYourBodyRow()
    } }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, showSystemUi = true)
@Composable
fun ScreenContentPreview() {
    MySootheTheme {
            HomeScreen()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    MySootheTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavigationRailPreview() {
    MySootheTheme { SootheNavigationRail() }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePortraitPreview() {
    MySootheAppPortrait()
}

@Preview(widthDp = 640, heightDp = 260)
@Composable
fun MySootheLandscapePreview() {
    MySootheAppLandscape()
}
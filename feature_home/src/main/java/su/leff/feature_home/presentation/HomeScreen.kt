package su.leff.feature_home.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import su.leff.design.components.subcomponents.VectorIconColorFilter
import su.leff.design.components.theming.*
import su.leff.feature_favourite.presentation.FavouriteScreen
import su.leff.feature_main.presentation.MainScreen
import su.leff.feature_profile.presentation.ProfileScreen
import su.leff.feature_profile.presentation.ProfileViewModel
import su.leff.feature_promo.presentation.PromoScreen
import su.leff.feature_search.presentation.SearchScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    onSettingsClicked: (() -> Unit),
    onInviteFriendsClicked: (() -> Unit),
    onHelpAndFeedbackClicked: () -> Unit,
    onEditProfileClicked: (() -> Unit),
    navigateToRewards: () -> Unit,
    onReset: () -> Unit,
) {
    var items = remember {
        mutableStateListOf(
            HomeNavigation.Search,
            HomeNavigation.Favourite,
            HomeNavigation.Main,
            HomeNavigation.Promocodes,
            HomeNavigation.Profile
        )
    }
    var previousScreen by remember { mutableStateOf<String?>(null) }
    val navController = rememberNavController().apply {
        addOnDestinationChangedListener { _, destination, _ ->
            val newScreen = destination.route ?: "unknown"
            previousScreen = newScreen
//            Toast.makeText(
//                context,
//                destination.route ?: "unknown",
//                Toast.LENGTH_SHORT,
//            ).show()
        }
    }
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = White()) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    val selected =
                        currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    BottomNavigationItem(
                        selectedContentColor = Black(),
                        unselectedContentColor = LightDarkGrey(),
                        icon = {
                            VectorIconColorFilter(
                                icon = screen.icon,
                                modifier = Modifier.size(24.dp),
                                color = if (selected) Black() else LightDarkGrey()
                            )
                        },

                        selected = selected,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
//                                popUpTo(navController.graph.findStartDestination().id) {
//                                    saveState = true
//                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeNavigation.Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(HomeNavigation.Profile.route) {
                ProfileScreen(
                    onSettingsClicked = onSettingsClicked,
                    onInviteFriendsClicked = onInviteFriendsClicked,
                    onHelpAndFeedbackClicked = onHelpAndFeedbackClicked,
                    onEditProfileClicked = onEditProfileClicked,
                    navigateToRewards = navigateToRewards,
                    onLogOut = onReset
                )
            }
            composable(HomeNavigation.Search.route) {
                SearchScreen(){}
            }
            composable(HomeNavigation.Main.route) { MainScreen() }
            composable(HomeNavigation.Favourite.route) {
                FavouriteScreen()
            }
            composable(HomeNavigation.Promocodes.route) {
                PromoScreen()
            }
        }
    }
}
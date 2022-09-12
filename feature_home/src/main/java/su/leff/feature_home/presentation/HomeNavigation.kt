package su.leff.feature_home.presentation

import su.leff.design.R

sealed class HomeNavigation(val icon: Int, val route: String) {
    object Search : HomeNavigation(
        icon = R.drawable.ic_search,
        route = "search"
    )

    object Favourite : HomeNavigation(
        icon = R.drawable.ic_favorite,
        route = "favorite"
    )

    object Main : HomeNavigation(
        icon = R.drawable.ic_star,
        route = "main"
    )

    object Profile : HomeNavigation(
        icon = R.drawable.ic_profile,
        route = "profile"
    )

    object Promocodes : HomeNavigation(
        icon = R.drawable.ic_gift,
        route = "promocodes"
    )
}
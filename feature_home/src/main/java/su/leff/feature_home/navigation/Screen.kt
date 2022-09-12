package su.leff.feature_home.navigation

sealed class Screen(
    open val routeBody: String,
    open val suffix: String? = null,
) {
    val route: String
        get() {
            return if (routeBody.isNotBlank() && suffix != null) routeBody + suffix
            else routeBody
        }

    object HomeScreen : Screen("home")
    object SettingsScreen : Screen("settings")
    object InviteFriendsScreen : Screen("inviteFriends")
    object HelpScreen : Screen("help")
    object EditProfileScreen : Screen("editProfile")
    object NavigateToRewardsScreen : Screen("navigateToRewards")
    object ResetScreen : Screen("reset")
}
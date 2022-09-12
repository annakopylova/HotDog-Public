package su.leff.feature_home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import su.leff.feature_home.presentation.HomeScreen


@Composable
fun SetupMainNavigation(
    navController: NavHostController,
    finishRootScreenAction: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
//        startDestination = Screen.CommunityChooseUsername.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(onSettingsClicked = {
                navController.navigate(Screen.SettingsScreen.route)
            },
                onInviteFriendsClicked = {
                    navController.navigate(Screen.InviteFriendsScreen.route)
                },
                onHelpAndFeedbackClicked = {
                    navController.navigate(Screen.HelpScreen.route)
                },
                onEditProfileClicked = {
                    navController.navigate(Screen.EditProfileScreen.route)
                },
                navigateToRewards = {
                    navController.navigate(Screen.NavigateToRewardsScreen.route)
                },
                onReset = {
                    navController.navigate(Screen.ResetScreen.route)
                })
        }
        composable(Screen.SettingsScreen.route){

        }
        composable(Screen.InviteFriendsScreen.route){

        }
        composable(Screen.HelpScreen.route){

        }
        composable(Screen.EditProfileScreen.route){

        }
        composable(Screen.NavigateToRewardsScreen.route){

        }
        composable(Screen.ResetScreen.route){

        }
    }
}
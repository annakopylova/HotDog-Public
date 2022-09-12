package su.leff.feature_profile.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest
import su.leff.design.components.profile.Avatar
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.subcomponents.VerticalSpacer
import su.leff.design.components.theming.Black
import su.leff.design.components.theming.nunitoBold
import su.leff.design.components.theming.nunitoMedium
import su.leff.design.ext.unboundClickable
import su.leff.core.R
import su.leff.design.components.profile.SubScreenButton
import su.leff.design.components.profile.SubscriptionCard
import su.leff.design.components.theming.WideButton

@Composable
fun ProfileScreen(
    onLogOut: (() -> Unit) = {},
    onSettingsClicked: (() -> Unit),
    onEditProfileClicked: (() -> Unit),
    onInviteFriendsClicked: (() -> Unit),
    onHelpAndFeedbackClicked: () -> Unit,
    navigateToRewards: () -> Unit,
    vm: ProfileViewModel = ProfileViewModel()
) {
    val uriHandler = LocalUriHandler.current
    val state = vm.state.uiState.collectAsState().value
    var signOutDialogShown by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        vm.logOutBus.events.collectLatest {
            it?.let {
                onLogOut()
            }
        }
    }

    ProfileContent(
        state = state,
        navigateToRewards = navigateToRewards,
        onEditProfileClicked = onEditProfileClicked,
        onSettingsClicked = onSettingsClicked,
        onHelpAndFeedbackClicked = onHelpAndFeedbackClicked,
        onInviteFriendsClicked = onInviteFriendsClicked,
        updateSignOutDialogShown = { signOutDialogShown = it },
        uriHandler = uriHandler
    )

//    if (signOutDialogShown) {
//        SignOutDialog(onAccept = {
//            signOutDialogShown = false
//            vm.signOut()
//        }, onDismiss = {
//            signOutDialogShown = false
//        })
//    }
}

@Preview
@Composable
fun ProfilePreview(@PreviewParameter(LoaderProvider::class) loading: Boolean) {
    ProfileContent(
        state = ProfileViewModel.State(loading = loading),
        navigateToRewards = { /*TODO*/ },
        onEditProfileClicked = { /*TODO*/ },
        onSettingsClicked = { /*TODO*/ },
        onHelpAndFeedbackClicked = { /*TODO*/ },
        onInviteFriendsClicked = { /*TODO*/ },
        updateSignOutDialogShown = {},
        uriHandler = LocalUriHandler.current
    )
}


class LoaderProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(true, false)
}

@Composable
fun ProfileContent(
    state: ProfileViewModel.State,
    navigateToRewards: () -> Unit,
    onEditProfileClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onHelpAndFeedbackClicked: () -> Unit,
    onInviteFriendsClicked: () -> Unit,
    updateSignOutDialogShown: (Boolean) -> Unit,
    uriHandler: UriHandler
) {
    if (!state.loading) {
//        LoaderBox(visible = true)
    } else {
        Scaffold(topBar = {
            Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth()) {
                VectorIcon(
                    icon = su.leff.design.R.drawable.ic_gift,
                    modifier = Modifier
                        .padding(top = 4.dp, end = 16.dp)
                        .size(30.dp)
                        .unboundClickable(navigateToRewards)
                )
            }
        }, content = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Avatar(
                    modifier = Modifier.padding(top = 18.dp),
                    url = state.avatarPath,
                    name = if (state.firstName?.isEmpty() == true) state.userName
                        ?: "" else state.firstName
                        ?: "",
                    key = state.lastUserUpdateTime
                )
                Text(
                    text = state.firstName ?: "",
                    style = nunitoBold(color = Black(), size = 26),
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    text = state.userName ?: "",
                    style = nunitoMedium(color = Black(), size = 20),
                    modifier = Modifier.padding(top = 2.dp)
                )
                Text(
                    text = stringResource(R.string.edit_profile),
                    style = nunitoBold(color = Black(), size = 16),
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onEditProfileClicked
                        )
                )

                VerticalSpacer(32)

                SubscriptionCard() {

                }
                VerticalSpacer(12)
                SubScreenButton(
                    icon = su.leff.design.R.drawable.ic_settings,
                    title = stringResource(R.string.settings)
                ) {
                    onSettingsClicked()
                }
                VerticalSpacer(12)
                SubScreenButton(
                    icon = su.leff.design.R.drawable.ic_help,
                    title = stringResource(R.string.help_and_feedback)
                ) {
                    onHelpAndFeedbackClicked()
                }
                VerticalSpacer(12)
                SubScreenButton(
                    icon = su.leff.design.R.drawable.ic_info,
                    title = stringResource(R.string.about_hotdog)
                ) {
                    uriHandler.openUri("")
                }
                VerticalSpacer(12)
                SubScreenButton(
                    icon = su.leff.design.R.drawable.ic_email,
                    title = stringResource(R.string.invite_your_friends)
                ) {
                    onInviteFriendsClicked()
                }
                VerticalSpacer(24)
                WideButton(title = stringResource(R.string.log_out)) {
                    updateSignOutDialogShown(true)
                }
                VerticalSpacer(height = 16)
            }
        })
    }
}

data class ProfileContentPayload(
    val loading: Boolean
)

class ProfilePayloadProvider :
    CollectionPreviewParameterProvider<ProfileContentPayload>(
        listOf(
            ProfileContentPayload(true),
            ProfileContentPayload(false),
        )
    )

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileContent(
        state = ProfileViewModel.State(loading = false),
        navigateToRewards = { /*TODO*/ },
        onEditProfileClicked = { /*TODO*/ },
        onSettingsClicked = { /*TODO*/ },
        onHelpAndFeedbackClicked = { /*TODO*/ },
        onInviteFriendsClicked = { /*TODO*/ },
        updateSignOutDialogShown = {},
        uriHandler = LocalUriHandler.current
    )
}
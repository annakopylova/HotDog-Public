package su.leff.feature_profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.android.annotation.KoinViewModel
import su.leff.core.base.OneTimeEvent
import su.leff.core.base.UiStateFlow

@KoinViewModel
class ProfileViewModel(): ViewModel() {
    val state = object :
        UiStateFlow<State>(State(loading = true)) {}
    val logOutBus = object : OneTimeEvent<Unit?>(viewModelScope) {}

    data class State(
        val loading: Boolean,
        val firstName: String? = "Анна",
        val userName: String? = "Назарова",
        val email: String? = null,
        val avatarPath: String? = null,
        val lastUserUpdateTime: String? = null
    )
}
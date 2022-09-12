package su.leff.core.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class OneTimeEvent<T>(
    private val coroutineScope: CoroutineScope,
) {
    private val _events = MutableSharedFlow<T>()
    val events: Flow<T> = _events.asSharedFlow()

    fun emit(value: T) {
        coroutineScope.launch { _events.emit(value) }
    }

    fun emit(value: T, scope: CoroutineScope) {
        scope.launch { _events.emit(value) }
    }
}
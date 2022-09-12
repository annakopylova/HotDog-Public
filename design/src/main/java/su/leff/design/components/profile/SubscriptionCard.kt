package su.leff.design.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import su.leff.core.R
import su.leff.design.components.theming.ProfileButtonCard
import su.leff.design.components.theming.nunitoBlack
import su.leff.design.components.theming.nunitoSemiBold

@Composable
fun SubscriptionCard(onClick: (() -> Unit)) {
    ProfileButtonCard(onClick = onClick, content = {
        Column {
            Text(text = stringResource(R.string.subscription), style = nunitoBlack(size = 18))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = stringResource(R.string.subscription), style = nunitoSemiBold(size = 14))
        }
    }
    )
}
package su.leff.hotdog.presentation


import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import su.leff.feature_home.navigation.SetupMainNavigation

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainContent(this) }
    }

    @Composable
    private fun MainContent(activity: AppCompatActivity) {
        val ctx = LocalContext.current
        var previousScreen by remember { mutableStateOf<String?>(null) }
        val navController = rememberNavController().apply {
            addOnDestinationChangedListener { controller, destination, arguments ->

                val newScreen = destination.route ?: "unknown"

                previousScreen = newScreen
                Toast.makeText(
                    context,
                    destination.route ?: "unknown",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
        val app = activity.application

            SetupMainNavigation(
                navController = navController,
                finishRootScreenAction = {
                    finish()
                },

            )
        }

}
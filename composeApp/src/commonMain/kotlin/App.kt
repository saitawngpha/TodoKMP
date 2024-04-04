import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import data.MongoDB
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin
import org.koin.dsl.module
import presentation.Screen.home.HomeScreen
import presentation.Screen.home.HomeViewModel
import presentation.Screen.task.TaskViewModel

import todokmp.composeapp.generated.resources.Res
import todokmp.composeapp.generated.resources.compose_multiplatform


val lightRedColor = Color(color = 0xFFF57D88)
val darkRedColor = Color(color = 0xFF77000B)

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {

        initializeKoin()

        val lightColors = lightColorScheme(
            primary = lightRedColor,
            onPrimary = darkRedColor,
            primaryContainer = lightRedColor,
            onPrimaryContainer = darkRedColor
        )
        val darkColors = darkColorScheme(
            primary = lightRedColor,
            onPrimary = darkRedColor,
            primaryContainer = lightRedColor,
            onPrimaryContainer = darkRedColor
        )
        val colors by mutableStateOf(
            if (isSystemInDarkTheme()) darkColors else lightColors
        )

    MaterialTheme(colorScheme = colors) {
        Navigator(HomeScreen()) {
            SlideTransition(it)
        }
    }
}

val moduleMongoDB = module {
    single { MongoDB() }
    factory { HomeViewModel(get()) }
    factory { TaskViewModel(get()) }
}

fun initializeKoin() {
    startKoin {
        modules(moduleMongoDB)
    }
}
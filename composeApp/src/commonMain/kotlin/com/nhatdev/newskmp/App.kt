package com.nhatdev.newskmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nhatdev.newskmp.theme.NewsTheme
import com.nhatdev.newskmp.ui.setting.SettingViewModel
import com.nhatdev.newskmp.utils.Theme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import newskmp.composeapp.generated.resources.Res
import newskmp.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    // State to track the current theme

    var settingViewModel = koinViewModel<SettingViewModel>()
    var currentTheme by remember { mutableStateOf(Theme.LIGHT_MODE.name) }

    // Apply the NewsTheme with the current theme mode
    NewsTheme(appTheme = currentTheme) {
        // MainScreen content
        MainScreen(settingViewModel)


        // sample UI
        ThemeSwitcherSample(
            currentTheme = currentTheme,
            onThemeChanged = { newTheme ->
                currentTheme = newTheme
            }
        )
    }
}

@Composable
fun ThemeSwitcherSample(
    currentTheme: String,
    onThemeChanged: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App logo
            Image(
                painterResource(Res.drawable.compose_multiplatform),
                contentDescription = "Compose Multiplatform logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // App title
            Text(
                "News KMP App",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Theme switcher card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Theme Settings",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Display current theme
                    Text(
                        "Current theme: ${if (currentTheme == Theme.LIGHT_MODE.name) "Light Mode" else "Dark Mode"}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Theme toggle button
                    Button(
                        onClick = {
                            // Toggle between Light and Dark mode
                            val newTheme = if (currentTheme == Theme.LIGHT_MODE.name)
                                Theme.DARK_MODE.name else Theme.LIGHT_MODE.name
                            onThemeChanged(newTheme)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(
                            if (currentTheme == Theme.LIGHT_MODE.name)
                                "Switch to Dark Mode"
                            else
                                "Switch to Light Mode"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Demo content section
            var showContent by remember { mutableStateOf(false) }

            Button(
                onClick = { showContent = !showContent },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(if (showContent) "Hide Demo Content" else "Show Demo Content")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Animated content section
            AnimatedVisibility(showContent) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Demo Content",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "This is a sample of how your content will look in different themes. " +
                            "Notice how colors automatically adjust based on the selected theme.",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}
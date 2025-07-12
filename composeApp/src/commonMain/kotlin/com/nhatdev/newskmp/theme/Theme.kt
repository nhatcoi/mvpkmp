package com.nhatdev.newskmp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.nhatdev.newskmp.utils.Theme
import newskmp.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font

// Định nghĩa dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Định nghĩa light color scheme
private val LightColorScheme = darkColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)


// Dark and light mode
@Composable
fun NewsTheme(
    appTheme: String?, // mode
    darkTheme: Boolean = isSystemInDarkTheme(), // lấy mode hệ thống
    content: @Composable () -> Unit // lambda UI slot - UI bọc
) {
    // similar to switch - case
    val colorScheme = when (appTheme) {
        Theme.LIGHT_MODE.name -> {
            LightColorScheme
        }

        Theme.DARK_MODE.name -> {
            DarkColorScheme
        }

        else -> {
            if (darkTheme) {
                DarkColorScheme
            } else {
                LightColorScheme
            }
        }
    }

    // wrap content with MaterialTheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = CustomTypography()
    )
}

// return custom typography - hàm tạo bộ chữ mặc định
@Composable
fun CustomTypography() = Typography().run {
    val fontFamily = FontFamily(Font(Res.font.open_sans))

    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}
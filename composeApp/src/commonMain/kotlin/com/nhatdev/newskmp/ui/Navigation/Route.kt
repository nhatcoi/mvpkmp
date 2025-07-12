package com.nhatdev.newskmp.ui.Navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Headline : Route
    @Serializable
    data object Search : Route
    @Serializable
    data object Bookmark : Route
    @Serializable
    data object NewDetail : Route
    @Serializable
    data object SettingDetail : Route
}
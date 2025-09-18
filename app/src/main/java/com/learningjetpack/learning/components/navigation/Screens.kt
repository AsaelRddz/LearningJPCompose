package com.learningjetpack.learning.components.navigation

import com.learningjetpack.learning.components.navigation.examples.model.SettingsModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test : Boolean)

@Serializable
data class Settings(val set: SettingsModel)
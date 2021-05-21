package me.katsumag.csproject.models

import kotlinx.serialization.Serializable


@Serializable
data class Component(val mantissa: String, val exponent: String)

package com.guarascio.evopoller2.weather.domainobjects

enum class Condition (val color: String) {
    NOT_SURE("Not Sure"),
    SHOWERS("Showers"),
    SNOW("Snow"),
    MOSTLY_CLOUDY("Mostly Cloudy"),
    PARTLY_CLOUDY("Partly Cloudy"),
    FINE("Fine")
}
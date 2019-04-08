package com.guarascio.evopoller2.weather.domainobjects

import java.util.*

data class Weather(
        var date: Date,
        var temperature: Double,
        var condition: Condition
)
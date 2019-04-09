package com.guarascio.evopoller2.weather.adapters.wunderground

import com.guarascio.evopoller2.weather.domainobjects.Condition

interface ConditionFactory {
    fun condition(weather: OpenWeatherMapCondition.OpenWeatherMapWeather): Condition
}
package com.guarascio.evopoller2.weather.adapters.wunderground

import com.guarascio.evopoller2.weather.adapters.wunderground.OpenWeatherMapCondition.OpenWeatherMapWeather
import com.guarascio.evopoller2.weather.domainobjects.Condition

class ConditionTranslator {

    var translator = CompositeTranslator(
            Thunderstorm(),
            Drizzle(),
            Rain(),
            Snow(),
            Atmosphere(),
            Clear(),
            PartlyCloudy(),
            MostlyCloudy(),
            Cloudy()
    )

    fun condition(weather: OpenWeatherMapWeather) = translator.condition(weather)?:Condition.NOT_SURE

    interface Translator {
        fun condition(weather: OpenWeatherMapWeather): Condition?

    }

    class CompositeTranslator(vararg val translators: Translator): Translator {
        override fun condition(weather: OpenWeatherMapWeather): Condition? {
            return translators
                    .map { t -> t.condition(weather) }
                    .firstOrNull { it != null }
        }
    }

    abstract class AtomicTranslator: Translator {
        override fun condition(weather: OpenWeatherMapWeather): Condition? {
            return if (conditionMatched(weather)) condition() else null
        }

        abstract fun condition(): Condition
        abstract fun conditionMatched(weather: OpenWeatherMapWeather): Boolean
    }

    class Thunderstorm: AtomicTranslator() {
        override fun condition() = Condition.SHOWERS
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id in (200..299)
    }

    class Drizzle: AtomicTranslator() {
        override fun condition() = Condition.SHOWERS
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id in (300..399)
    }

    class Rain: AtomicTranslator() {
        override fun condition() = Condition.SHOWERS
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id in (500..599)
    }

    class Snow: AtomicTranslator() {
        override fun condition() = Condition.SNOW
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id in (600..699)
    }

    class Atmosphere: AtomicTranslator() {
        override fun condition() = Condition.CLOUDY
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id in (700..799)
    }

    class Clear: AtomicTranslator() {
        override fun condition() = Condition.FINE
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id == 800
    }

    class PartlyCloudy: AtomicTranslator() {
        override fun condition() = Condition.PARTLY_CLOUDY
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id == 801
    }

    class MostlyCloudy: AtomicTranslator() {
        override fun condition() = Condition.MOSTLY_CLOUDY
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id in (802..803)
    }

    class Cloudy: AtomicTranslator() {
        override fun condition() = Condition.MOSTLY_CLOUDY
        override fun conditionMatched(weather: OpenWeatherMapWeather) = weather.id == 804
    }
}

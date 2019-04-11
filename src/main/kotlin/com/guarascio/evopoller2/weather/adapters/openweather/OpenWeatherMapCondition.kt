package com.guarascio.evopoller2.weather.adapters.openweather
import com.fasterxml.jackson.annotation.JsonProperty

data class OpenWeatherMapCondition(
        @JsonProperty("id") var id: Int,
        @JsonProperty("name") var name: String,
        @JsonProperty("main") var main: OpenWeatherMapMain,
        @JsonProperty("weather") var weather: Array<OpenWeatherMapWeather>
) {
    data class OpenWeatherMapMain(
            @JsonProperty("temp") var tempK: Double,
            @JsonProperty("temp_min") var tempKMin: Double,
            @JsonProperty("temp_max") var tempKMax: Double
    )

    data class OpenWeatherMapWeather(
            @JsonProperty("id") var id: Int,
            @JsonProperty("main") var main: String,
            @JsonProperty("description") var description: String
    )
}


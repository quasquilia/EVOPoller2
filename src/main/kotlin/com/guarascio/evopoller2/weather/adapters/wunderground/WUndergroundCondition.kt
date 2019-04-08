package com.guarascio.evopoller2.weather.adapters.wunderground
import com.fasterxml.jackson.annotation.JsonProperty

data class WUndergroundCondition(
        @JsonProperty("temp_c") var temperature: Double,
        @JsonProperty("weather") var weather: String
)
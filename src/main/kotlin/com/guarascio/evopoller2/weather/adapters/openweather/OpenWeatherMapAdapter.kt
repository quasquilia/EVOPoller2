package com.guarascio.evopoller2.weather.adapters.openweather

import com.guarascio.evopoller2.weather.domainobjects.Weather
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.util.*

class OpenWeatherMapAdapter {

    private var translator = ConditionTranslator()

    fun getWeather(): Weather {
        var restTemplate = RestTemplate()
        val conditions = restTemplate.getForObject(URI("http://api.openweathermap.org/data/2.5/weather?q=Capannori,it&appid="),
                OpenWeatherMapCondition::class.java)
        return Weather(Date(), conditions.main.tempK -273.15, translator.condition(conditions.weather[0]))
    }
/*
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(OpenWeatherMapAdapter().getWeather())
        }
    }

 */
}
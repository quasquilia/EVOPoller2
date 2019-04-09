package com.guarascio.evopoller2.weather.adapters.wunderground

import org.springframework.web.client.RestTemplate
import java.net.URI

class OpenWeatherMapAdapter {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            var restTemplate = RestTemplate()
            val wUndergroundCondition = restTemplate.getForObject(URI("http://api.openweathermap.org/data/2.5/weather?q=Capannori,it&appid="),
                    OpenWeatherMapCondition::class.java)

            println(wUndergroundCondition)

        }
    }
}
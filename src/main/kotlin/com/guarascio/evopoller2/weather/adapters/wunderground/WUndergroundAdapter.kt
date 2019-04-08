package com.guarascio.evopoller2.weather.adapters.wunderground

import org.springframework.web.client.RestTemplate
import java.net.URI

class WUndergroundAdapter {



    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            var restTemplate = RestTemplate()
            val wUndergroundCondition = restTemplate.getForObject(URI("http://api.wunderground.com/api/d645214de6bc3045/conditions/q/IT/Capannori.json"),
                    WUndergroundCondition::class.java)

            println(wUndergroundCondition)


        }
    }
}
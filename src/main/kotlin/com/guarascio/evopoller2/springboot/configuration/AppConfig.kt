package com.guarascio.evopoller2.springboot.configuration

import com.guarascio.evopoller2.inverter.adapters.evo.SirioEVOAdapter
import com.guarascio.evopoller2.inverter.ports.InverterPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled



@Configuration
@EnableScheduling
class AppConfig {

    @Bean
    fun inverterPort(properties: AppProperties): InverterPort {
        println("InverterPort created with url= $properties.inverterUrl")
        return SirioEVOAdapter(properties.inverterUrl)
    }
/*
    @Scheduled(fixedDelay = 1000)
    fun scheduleFixedDelayTask() {
        println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000)
    }
    */
}
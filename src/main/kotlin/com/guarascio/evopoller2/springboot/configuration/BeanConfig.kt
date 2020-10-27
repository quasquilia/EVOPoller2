package com.guarascio.evopoller2.springboot.configuration

import com.guarascio.evopoller2.inverter.adapters.evo.SirioEVOAdapter
import com.guarascio.evopoller2.inverter.ports.InverterPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig(@Autowired val properties: AppProperties) {

    @Bean
    fun inverterPort(): InverterPort
    {
        println("InverterPort created with url= $properties.inverterUrl")
        return SirioEVOAdapter(properties.inverterUrl)
    }
}
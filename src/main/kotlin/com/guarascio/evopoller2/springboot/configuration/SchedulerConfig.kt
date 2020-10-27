package com.guarascio.evopoller2.springboot.configuration

import com.guarascio.evopoller2.inverter.ports.InverterPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.Scheduled


@Configuration
@Import(value = [BeanConfig::class])
class SchedulerConfig (private val beanConfig: BeanConfig) {

    @Scheduled(fixedDelay = 1000)
    fun scheduleFixedDelayTask() {
        println("Power: ${this.beanConfig.inverterPort().loadSample()!!.power}")
    }
}
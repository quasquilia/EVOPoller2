package com.guarascio.evopoller2.springboot.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Configuration
@Import(value = [BeanConfig::class, SchedulerConfig::class])
class AppConfig (private val beanConfig: BeanConfig) {
}
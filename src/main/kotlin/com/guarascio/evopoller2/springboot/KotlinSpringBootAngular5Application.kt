package com.guarascio.evopoller2.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class KotlinSpringBootAngular5Application

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringBootAngular5Application::class.java, *args)
}

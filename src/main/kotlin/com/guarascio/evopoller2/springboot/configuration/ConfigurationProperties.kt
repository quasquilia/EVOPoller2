package com.guarascio.evopoller2.springboot.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("app")
data class AppProperties(
        @Value("\${application.inverterUrl}") var inverterUrl: String
) {

}
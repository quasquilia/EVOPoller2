package com.guarascio.evopoller2.springboot.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
 
@RestController
class WebRestController {
 
	@RequestMapping("/api/hi")
	fun hi(): String{
		return "Message from SpringBoot Restful API!"
	}
}
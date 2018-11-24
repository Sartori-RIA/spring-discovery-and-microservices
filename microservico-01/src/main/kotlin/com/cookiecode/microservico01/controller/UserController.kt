package com.cookiecode.microservico01.controller

import com.cookiecode.microservico01.structure.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun index(){
        println("olar")
    }
}
package com.cookiecode.microservico01

import com.cookiecode.microservico01.domain.User
import com.cookiecode.microservico01.structure.service.UserService
import com.github.javafaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@EnableDiscoveryClient
@SpringBootApplication
class EurekaClientApplication

fun main() {
    runApplication<EurekaClientApplication>()
}

@Component
class StartUpInit {

    @Autowired
    private lateinit var userService: UserService

    private val faker by lazy { Faker() }

    @PostConstruct
    fun postConstruct() {
        val users = ArrayList<User>()
        for (i in 0 until 1_000)
            users.add(User(faker.name().fullName()))
        userService.save(users)
    }

}
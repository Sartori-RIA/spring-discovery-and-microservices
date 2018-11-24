package com.cookiecode.microservico01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class EurekaClientApplication

fun main(){
    runApplication<EurekaClientApplication>()
}
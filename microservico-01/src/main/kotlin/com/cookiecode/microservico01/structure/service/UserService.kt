package com.cookiecode.microservico01.structure.service

import com.cookiecode.microservico01.domain.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*

@Component
interface UserService {
    fun findById(id: String): Optional<User>?

    fun delete(id: String)

    fun save(model: User): User

    fun findAll(pageable: Pageable?): Page<User>
}
package com.cookiecode.microservico01.structure.service

import com.cookiecode.microservico01.domain.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*

@Component
interface UserService {

    fun findById(id: Long): Optional<User>?

    fun delete(id: Long)

    fun save(user: User): User

    fun findAll(pageable: Pageable?): Iterable<User>
}
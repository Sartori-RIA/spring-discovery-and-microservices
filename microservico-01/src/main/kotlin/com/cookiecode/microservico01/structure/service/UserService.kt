package com.cookiecode.microservico01.structure.service

import com.cookiecode.microservico01.domain.User
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*

@Component
interface UserService {

    fun delete(id: Long)

    fun delete(user: User)

    fun save(user: User): User

    fun save(users: Iterable<User>): Iterable<User>

    fun findAll(pageable: Pageable?): Iterable<User>

    fun findById(id: Long): Optional<User>?

}
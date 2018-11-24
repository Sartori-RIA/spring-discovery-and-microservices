package com.cookiecode.microservico01.structure.service.impl

import com.cookiecode.microservico01.domain.User
import com.cookiecode.microservico01.structure.repository.UserRepository
import com.cookiecode.microservico01.structure.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun save(user: User) = userRepository.save(user)
}
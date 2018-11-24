package com.cookiecode.microservico01.structure.service.impl

import com.cookiecode.microservico01.domain.User
import com.cookiecode.microservico01.structure.repository.UserRepository
import com.cookiecode.microservico01.structure.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun save(user: User): User = userRepository.save(user)

    override fun findById(id: Long): Optional<User>? = userRepository.findById(id)

    override fun delete(id: Long) = userRepository.deleteById(id)

    override fun findAll(pageable: Pageable?): Iterable<User> {
        return if (pageable != null)
            userRepository.findAll(pageable)
        else userRepository.findAll()
    }
}
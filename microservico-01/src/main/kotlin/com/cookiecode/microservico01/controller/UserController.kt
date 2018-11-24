package com.cookiecode.microservico01.controller

import com.cookiecode.microservico01.domain.User
import com.cookiecode.microservico01.response.Response
import com.cookiecode.microservico01.structure.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun create(request: HttpServletRequest, @RequestBody user: User, result: BindingResult): ResponseEntity<Response<User>> {
        val response = Response<User>()
        try {
            validateCreateUser(user, result)
            takeIf { result.hasErrors() }?.apply {
                result.allErrors.forEach {  response.errors.add(it.defaultMessage!!) }
                return ResponseEntity.badRequest().body(response)
            }
            response.data = userService.save(user)
        } catch (e: DuplicateKeyException) {
            response.errors.add("Usuario já cadastrado")
            return ResponseEntity.badRequest().body(response)
        } catch (e: Exception) {
            response.errors.add("Erro Inesperado")
            return ResponseEntity.badRequest().body(response)
        }
        return ResponseEntity.ok(response)
    }

    @PatchMapping
    @PutMapping
    fun update(request: HttpServletRequest, @RequestBody user: User, result: BindingResult): ResponseEntity<Response<User>> {
        val response = Response<User>()
        try {
            validateUpdateUser(user, result)
            takeIf { result.hasErrors() }?.apply {
                result.allErrors.forEach { response.errors.add(it.defaultMessage!!) }
                return ResponseEntity.badRequest().body(response)
            }
            response.data = userService.save(user)
        } catch (e: Exception) {
            response.errors.add("Erro Inesperado")
            return ResponseEntity.badRequest().body(response)
        }
        return ResponseEntity.ok(response)
    }

    @GetMapping(value = ["{id}"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Response<User>> {
        val response = Response<User>()
        val user: User?
        try {
            user = userService.findById(id)?.get()
        } catch (e: NoSuchElementException) {
            response.errors.add("user not found")
            return ResponseEntity.badRequest().body(response)
        }
        response.data = user
        return ResponseEntity.ok(response)
    }

    @DeleteMapping(value = ["{id}"])
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<Response<String>> {
        val response = Response<String>()
        val user = userService.findById(id)
        if (user == null) {
            response.errors.add("user not found")
            return ResponseEntity.badRequest().body(response)
        }
        userService.delete(id)
        return ResponseEntity.ok(Response())
    }


    @GetMapping
    fun all(page: Pageable?): ResponseEntity<Response<Iterable<User>>> {
        val response = Response<Iterable<User>>()
        response.data = userService.findAll(page)
        return ResponseEntity.ok(response)
    }


    private fun validateCreateUser(user: User, result: BindingResult) {
        takeIf { user.name.isBlank() }?.apply { result.addError(ObjectError("User", "user name cannot be empty")) }
    }

    private fun validateUpdateUser(user: User, result: BindingResult) {
        takeIf { user.id != 0L}?.apply { result.addError(ObjectError("User", "user id cannot be empty")) }
        takeIf { user.name.isBlank() }?.apply { result.addError(ObjectError("User", "user name cannot be empty")) }
    }
}
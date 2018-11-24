package com.cookiecode.microservico01.domain

import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    lateinit var createdAt: Date

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    lateinit var updatedAt: Date

    @PrePersist
    fun prePersist() {
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = Date()
    }
}
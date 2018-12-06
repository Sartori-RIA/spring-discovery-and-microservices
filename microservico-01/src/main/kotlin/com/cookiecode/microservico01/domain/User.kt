package com.cookiecode.microservico01.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Table(name = "users")
@Entity
data class User(@NotEmpty
                @NotNull
                @NotBlank
                @Column(name = "name")
                var name: String = "") : AbstractEntity()
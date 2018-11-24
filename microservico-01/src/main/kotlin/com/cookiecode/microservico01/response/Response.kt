
package com.cookiecode.microservico01.response

class Response<T> {
    var data: T? = null
    var errors = ArrayList<String>()
}

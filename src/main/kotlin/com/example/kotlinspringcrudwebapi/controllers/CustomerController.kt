package com.example.kotlinspringcrudwebapi.controllers

import com.example.kotlinspringcrudwebapi.CustomerService
import com.example.kotlinspringcrudwebapi.models.Customer
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController(val customerService: CustomerService) {
    @PostMapping("/customers")
    fun insert(@RequestBody request: CustomerRequest): String {
        customerService.insertCustomer(request.firstName, request.lastName)
        return """
            {
                "message": "success"
            }
        """.trimIndent()
    }

    @GetMapping("/customers")
    fun read(): CustomerResponse {
        return CustomerResponse(customers = customerService.selectCustomer())
    }

    @PutMapping("/customers/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: CustomerRequest): String {
        customerService.updateCustomer(id, request.firstName, request.lastName)
        return """
            {
                "message": "success"
            }
        """.trimIndent()
    }

    @DeleteMapping("/customers/{id}")
    fun delete(@PathVariable("id") id: Long): String {
        customerService.deleteCustomer(id)
        return """
            {
                "message": "success"
            }
        """.trimIndent()
    }
}

data class CustomerRequest(
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_name") val lastName: String,
)

data class CustomerResponse(
        val customers: List<Customer>,
)

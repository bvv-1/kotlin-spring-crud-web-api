package com.example.kotlinspringcrudwebapi.controllers

import com.example.kotlinspringcrudwebapi.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
class MainController(val customerService: CustomerService) {
    @GetMapping("/")
    fun hello(): String {
        return "Hello, world!"
    }
}

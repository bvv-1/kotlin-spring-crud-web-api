package com.example.kotlinspringcrudwebapi

import com.example.kotlinspringcrudwebapi.models.Customer
import org.springframework.stereotype.Service

interface CustomerService {
    fun insertCustomer(firstName: String, lastName: String)

    fun selectCustomer(): List<Customer>

    fun updateCustomer(id: Long, firstName: String, lastName: String)

    fun deleteCustomer(id: Long)
}

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    override fun insertCustomer(firstName: String, lastName: String) {
        customerRepository.add(firstName, lastName)
        return
    }

    override fun selectCustomer(): List<Customer> {
        return customerRepository.find()
    }

    override fun updateCustomer(id: Long, firstName: String, lastName: String) {
        customerRepository.update(id, firstName, lastName)
        return
    }

    override fun deleteCustomer(id: Long) {
        customerRepository.delete(id)
        return
    }
}

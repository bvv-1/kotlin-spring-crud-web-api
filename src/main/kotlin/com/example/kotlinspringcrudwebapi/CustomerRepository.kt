package com.example.kotlinspringcrudwebapi

import com.example.kotlinspringcrudwebapi.models.Customer
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface CustomerRepository {
    fun add(firstName: String, lastName: String)

    fun find(): List<Customer>

    fun update(id: Long, firstName: String, lastName: String)

    fun delete(id: Long)
}

@Repository
class CustomerRepositoryImpl(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : CustomerRepository {
    override fun add(firstName: String, lastName: String) {
        val sql = "INSERT INTO customer(first_name, last_name) VALUES(:firstName, :lastName)"
        val sqlParams = MapSqlParameterSource().addValue("first_name", firstName).addValue("last_name", lastName)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun find(): List<Customer> {
        val sql = "SELECT * FROM customer"
        val sqlParams = MapSqlParameterSource()
        val customerMap = namedParameterJdbcTemplate.queryForList(sql, sqlParams)
        return customerMap.map {
            Customer(
                it["id"].toString().toLong(),
                it["username"].toString(),
                it["password"].toString(),
                it["salt"].toString(),
                it["email"].toString(),
                it["first_name"].toString(),
                it["last_name"].toString(),
                LocalDate.parse(it["date_of_birth"].toString(), DateTimeFormatter.ISO_DATE),
                it["address"].toString(),
                it["stripe_customer_id"].toString(),
                LocalDateTime.parse(it["created_at"].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"))
            )
        }
    }

    override fun update(id: Long, firstName: String, lastName: String) {
        val sql = "UPDATE customer SET first_name = :first_name, last_name = :last_name WHERE id = :id"
        val sqlParams =
            MapSqlParameterSource().addValue("id", id).addValue("first_name", firstName).addValue("last_name", lastName)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun delete(id: Long) {
        val sql = "DELETE FROM customer WHERE id = :id"
        val sqlParams = MapSqlParameterSource().addValue("id", id)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }
}

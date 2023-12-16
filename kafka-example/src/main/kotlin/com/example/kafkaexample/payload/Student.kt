package com.example.kafkaexample.payload

import lombok.ToString

@ToString
data class Student(
    var id: Int,
    var firstname: String,
    var lastname: String
)
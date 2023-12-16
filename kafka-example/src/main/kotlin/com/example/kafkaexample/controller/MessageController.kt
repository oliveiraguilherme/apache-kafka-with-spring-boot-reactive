package com.example.kafkaexample.controller

import com.example.kafkaexample.config.KafkaProducerConfig
import com.example.kafkaexample.payload.Student
import com.example.kafkaexample.producer.KafkaJsonProducer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/messages")
class MessageController(
    private val kafkaProducerConfig: KafkaProducerConfig,
    private val kafkaJsonProducer: KafkaJsonProducer
) {

    @PostMapping
    fun sendMessage(@RequestBody message: String): ResponseEntity<String>{
        kafkaProducerConfig.sendMessage(message)
        return ResponseEntity.ok("Message queued successfully")
    }

    @PostMapping("/json")
    fun sendJsonMessage(@RequestBody message: Student): ResponseEntity<String>{
        kafkaJsonProducer.sendMessage(message)
        return ResponseEntity.ok("Message queued successfully as JSON")
    }
}
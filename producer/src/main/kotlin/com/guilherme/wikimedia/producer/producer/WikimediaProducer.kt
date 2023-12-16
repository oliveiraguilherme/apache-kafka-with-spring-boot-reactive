package com.guilherme.wikimedia.producer.producer

import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
@Slf4j
class WikimediaProducer(

    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val log: Logger? = LoggerFactory.getLogger(WikimediaProducer::class.java)
) {

    fun sendMessage(msg: String) {
        //log?.info(String.format("Sending message to wikipedia-stream Topic: $msg"))
        kafkaTemplate.send("wikimedia-stream", msg)
    }
}
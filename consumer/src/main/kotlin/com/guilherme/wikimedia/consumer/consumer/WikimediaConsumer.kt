package com.guilherme.wikimedia.consumer.consumer

import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
@Slf4j
class WikimediaConsumer(
    private val log: Logger? = LoggerFactory.getLogger(WikimediaConsumer::class.java)
) {

    @KafkaListener(topics = ["wikimedia-stream"], groupId = "myGroup")
    fun consumeMessage(msg: String){
        log?.info("Consuming the message from wikimedia-stream Topic: $msg")

        //Parei aqui, ele vai iniciar as aplicações min 1:34:51
    }
}
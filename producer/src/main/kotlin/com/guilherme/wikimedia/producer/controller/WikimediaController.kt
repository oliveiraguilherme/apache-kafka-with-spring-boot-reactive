package com.guilherme.wikimedia.producer.controller

import com.guilherme.wikimedia.producer.stream.WikimediaStreamConsumer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/wikimedia")
class WikimediaController(
    private val streamConsumer: WikimediaStreamConsumer
) {

    @GetMapping
    fun startPublishing(){
        streamConsumer.consumeStreamAndPublish()
    }
}
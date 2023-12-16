package com.guilherme.wikimedia.producer.stream

import com.guilherme.wikimedia.producer.producer.WikimediaProducer
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.slf4j.Logger
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
@Slf4j
class WikimediaStreamConsumer(
    webClientBuilder: WebClient.Builder,
    private val producer: WikimediaProducer
) {
    private val webClient: WebClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2")
        .build()

    companion object{
        private val log: Logger? = LoggerFactory.getLogger(WikimediaStreamConsumer::class.java)
    }

    fun consumeStreamAndPublish(){
        webClient
            .get()
            .uri("/stream/recentchange")
            .retrieve()
            .bodyToFlux(String::class.java)
            .subscribe(producer::sendMessage)
        //{ message -> log?.info(message) }
    }
}
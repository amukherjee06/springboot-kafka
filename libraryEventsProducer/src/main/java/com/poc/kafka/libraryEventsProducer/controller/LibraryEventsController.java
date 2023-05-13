package com.poc.kafka.libraryEventsProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.kafka.libraryEventsProducer.domain.LibraryEvent;
import com.poc.kafka.libraryEventsProducer.producer.LibraryEventProducer;

@RestController
public class LibraryEventsController {

	@Autowired
	LibraryEventProducer libraryEventProducer;
	
	@PostMapping("/v1/libraryEvent")
	public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException{
		
		libraryEventProducer.sendLibraryEvent(libraryEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
	}

}

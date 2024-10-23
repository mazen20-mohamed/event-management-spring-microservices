package com.event.manager.microservice.EventService.controller;

import com.event.manager.microservice.EventService.dto.EventRequest;
import com.event.manager.microservice.EventService.dto.EventResponse;
import com.event.manager.microservice.EventService.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse CreateEvent(@RequestBody EventRequest eventRequest) {

        return eventService.CreateEvent(eventRequest);

    }

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse GetEventById(@PathVariable String eventId) {

    return eventService.getEvent(eventId);

    }

    @DeleteMapping("/{eventId}")
    @Transactional
    public String DeleteEvent(@PathVariable("eventId") String eventId) {
        eventService.deleteEvent(eventId);
        return "Event Deleted";
    }

    @PutMapping("/{eventId}")
    public EventResponse UpdateEvent(@PathVariable("eventId") String eventId,@RequestBody EventRequest eventRequest) {
        return eventService.updateEvent(eventId,eventRequest);
    }




}

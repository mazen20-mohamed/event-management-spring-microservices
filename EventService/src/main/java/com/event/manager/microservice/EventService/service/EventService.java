package com.event.manager.microservice.EventService.service;

import com.event.manager.microservice.EventService.dto.EventRequest;
import com.event.manager.microservice.EventService.dto.EventResponse;
import com.event.manager.microservice.EventService.model.Event;
import com.event.manager.microservice.EventService.respository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventRepository eventRepository;

    public EventResponse CreateEvent(EventRequest eventRequest) {
        Event event = Event.builder()
                .title(eventRequest.title())
                .description(eventRequest.description())
                .startDate(eventRequest.startDate())
                .endDate(eventRequest.endDate())
                .organizerId(eventRequest.organizerId())
                .maxAttendees(eventRequest.maxAttendees())
                .fee(eventRequest.fee())
                .build();
        eventRepository.save(event);
        return new EventResponse(event.getId(), event.getTitle(), event.getDescription(), event.getStartDate(),
                event.getEndDate(), event.getOrganizerId(), event.getMaxAttendees(), event.getFee());
    }


    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }

    public EventResponse getEvent(String eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event == null) {
            throw new RuntimeException("Did not find the event with this id - " + eventId);
        }
        return new EventResponse(event.getId(), event.getTitle(), event.getDescription(), event.getStartDate(),
                event.getEndDate(), event.getOrganizerId(), event.getMaxAttendees(), event.getFee());

    }
    public EventResponse updateEvent(String eventId, EventRequest eventRequest) {
        Event event =eventRepository.findById(eventId).orElse(null);
        if (event == null) {
            throw new RuntimeException("Did not find the event with this id - " + eventId);
        }
        event.setTitle(eventRequest.title());
        event.setDescription(eventRequest.description());
        event.setStartDate(eventRequest.startDate());
        event.setEndDate(eventRequest.endDate());
        event.setOrganizerId(eventRequest.organizerId());
        event.setMaxAttendees(eventRequest.maxAttendees());
        event.setFee(eventRequest.fee());

        eventRepository.save(event);

        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getStartDate(),
                event.getEndDate(),
                event.getOrganizerId(),
                event.getMaxAttendees(),
                event.getFee()
        );
    }
}

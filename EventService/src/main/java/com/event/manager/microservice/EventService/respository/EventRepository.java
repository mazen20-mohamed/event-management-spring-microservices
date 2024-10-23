package com.event.manager.microservice.EventService.respository;

import com.event.manager.microservice.EventService.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}

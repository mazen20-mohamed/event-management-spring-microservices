package com.event.manager.microservice.EventService.dto;

import java.util.Date;

public record EventResponse(String id, String title, String description, Date startDate,
                            Date endDate, String organizerId, Integer maxAttendees, Integer fee) {
}

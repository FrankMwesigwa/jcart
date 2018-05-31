package com.jcart.modules.tracker.status;

import lombok.Data;

@Data
public class TrackerDTO {

    private Long id;
    private String name;

    public TrackerDTO(){}

    public TrackerDTO (TrackerStatus status) {
        this(
                status.getId(),
                status.getName()
        );
    }

    public TrackerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

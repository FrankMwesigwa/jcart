package com.jcart.modules.tracker.status;

import lombok.Data;

@Data
public class TrackerResponse {

    private Long id;
    private String name;

    public TrackerResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

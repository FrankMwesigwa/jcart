package com.jcart.modules.tracker.status;

import org.springframework.web.bind.annotation.*;


@RestController
public class TrackerStatusController {

    private TrackerStatusRepository statusRepository;

    public TrackerStatusController(TrackerStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

}

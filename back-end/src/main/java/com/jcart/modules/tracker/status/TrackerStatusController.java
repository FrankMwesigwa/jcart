package com.jcart.modules.tracker.status;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TrackerStatusController {

    private TrackerStatusRepository statusRepository;

    public TrackerStatusController(TrackerStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/batch/branches")
    public List<TrackerResponse> getBranches() {
        return statusRepository.getTrackerResponse();
    }

}

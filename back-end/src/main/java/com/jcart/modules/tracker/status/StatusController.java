package com.jcart.modules.tracker.status;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class StatusController {

    private StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }




}

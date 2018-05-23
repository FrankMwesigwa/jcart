package com.jcart.modules.tracker.batch;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BatchController {

    private BatchRepository batchRepository;;

    public BatchController(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @GetMapping("/batch")
    public List<Batch> getAll() {
        return batchRepository.findAll();
    }

}

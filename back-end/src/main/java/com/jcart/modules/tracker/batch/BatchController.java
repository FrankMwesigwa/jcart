package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.branch.BranchDTO;
import com.jcart.modules.tracker.branch.BranchRepository;
import com.jcart.modules.utilities.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class BatchController {

    private BatchRepository batchRepository;
    private BranchRepository branchRepository;

    public BatchController(BatchRepository batchRepository , BranchRepository branchRepository) {
        this.batchRepository = batchRepository;
        this.branchRepository = branchRepository;
    }

    @GetMapping("/batch")
    public List<BatchResponse> getAll() {
        return batchRepository.retrieveBatchResponse();
    }

    @GetMapping("/batch/branches")
    public List<BranchDTO> getBranches() {
        return branchRepository.retrieveBranchDTO();
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody BatchDTO batchDetails) {

        Batch batch = new Batch();

        batch.setName(batchDetails.getName());
        batch.setDescription(batchDetails.getDescription());
        batch.setBranch(branchRepository.getOne(batchDetails.getBranch()));

        Batch result = batchRepository.save(batch);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/batch")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Batch created successfully"));
    }


}

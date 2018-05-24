package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.branch.Branch;
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
    public List<BatchDTO> getAll() {
        return batchRepository.retrieveBatchAsDTO();
    }

    @GetMapping("/batch/branches")
    public List<BranchDTO> getBranches() {
        return branchRepository.retrieveBranchDTO();
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody BatchDTO batchDetails) {
        Batch batch = new Batch();

        Branch branchId = branchRepository.getOne(batchDetails.getBranch().getId());

        batch.setName(batchDetails.getName());
        batch.setDescription(batchDetails.getDescription());
        batch.setBranch(branchId);

        Batch result = batchRepository.save(batch);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/batch")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Batch created successfully"));
    }


}

package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.Tran.Tran;
import com.jcart.modules.tracker.Tran.TranRepository;
import com.jcart.modules.tracker.account.Account;
import com.jcart.modules.tracker.account.AccountRepository;
import com.jcart.modules.tracker.branch.BranchDTO;
import com.jcart.modules.tracker.branch.BranchRepository;
import com.jcart.modules.tracker.status.TrackerResponse;
import com.jcart.modules.tracker.status.TrackerStatusRepository;
import com.jcart.modules.utilities.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
public class BatchController {

    private BatchRepository batchRepository;
    private BranchRepository branchRepository;
    private TranRepository tranRepository;
    private TrackerStatusRepository statusRepository;

    public BatchController(BatchRepository batchRepository , BranchRepository branchRepository,
                           TranRepository tranRepository, TrackerStatusRepository statusRepository) {
        this.batchRepository = batchRepository;
        this.branchRepository = branchRepository;
        this.tranRepository = tranRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/batch")
    public List<BatchResponse> getAll() {
        return batchRepository.retrieveBatchResponse();
    }

    @GetMapping("/batch/branches")
    public List<BranchDTO> getBranches() {
        return branchRepository.retrieveBranchDTO();
    }

    @GetMapping("/batch/status")
    public List<TrackerResponse> getStatus() {
        return statusRepository.getTrackerResponse();
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody BatchDTO batchDetails) {

        Batch batch = new Batch();

        batch.setName(batchDetails.getName());
        batch.setBatchStatus("Open");
        batch.setDescription(batchDetails.getDescription());
        batch.setBranch(branchRepository.getOne(batchDetails.getBranch()));
        batch.setStatus(statusRepository.getOne(batchDetails.getStatus()));

        Batch result = batchRepository.save(batch);

        batchDetails.getAccounts().forEach(accountRequest -> {
            batch.addAccount(new Account(
                    accountRequest.getAccountName(),
                    accountRequest.getAccountNo(),
                    accountRequest.getClientCode(),
                    accountRequest.getAccountType()));
        });

        Tran transactions = new Tran();
        transactions.setBatchId(batch.getId());
        transactions.setCreatedDate(new Date());
        transactions.setStatusId(batch.getStatus().getId());
        transactions.setCreatedBy("Frank");
        transactions.setComments("initial request");
        tranRepository.save(transactions);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/batch")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Batch created successfully"));
    }


}

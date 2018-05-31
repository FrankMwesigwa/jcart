package com.jcart.modules.tracker.batch;

import com.jcart.modules.exceptions.ResourceNotFoundException;
import com.jcart.modules.security.auth.CurrentUser;
import com.jcart.modules.security.auth.UserPrincipal;
import com.jcart.modules.security.users.User;
import com.jcart.modules.security.users.UserRepository;
import com.jcart.modules.tracker.Tran.Tran;
import com.jcart.modules.tracker.Tran.TranRepository;
import com.jcart.modules.tracker.account.Account;
import com.jcart.modules.tracker.branch.BranchDTO;
import com.jcart.modules.tracker.branch.BranchRepository;
import com.jcart.modules.tracker.status.TrackerDTO;
import com.jcart.modules.tracker.status.TrackerStatusRepository;
import com.jcart.modules.utilities.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    private UserRepository userRepository;

    public BatchController(BatchRepository batchRepository, BranchRepository branchRepository,
                           TranRepository tranRepository, TrackerStatusRepository statusRepository,
                           UserRepository userRepository) {
        this.batchRepository = batchRepository;
        this.branchRepository = branchRepository;
        this.tranRepository = tranRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/batch")
    public ResponseEntity<List<BatchDTO>> getAllUsers(Pageable pageable) {
        final Page<BatchDTO> page = batchRepository.findAll(pageable).map(BatchDTO::new);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/batch/{id}")
    public BatchResponse getBatchById(@CurrentUser UserPrincipal currentUser,
                                      @PathVariable(value = "id") Long batchId) {
        Batch batch = batchRepository.findById(batchId).orElseThrow(
                () -> new ResourceNotFoundException("Batch", "id", batchId));

        User creator = userRepository.findById(batch.getCreatedBy());
        return ModelMapper.mapBatchToBatchResponse(batch, creator);
    }

    @GetMapping("/batch/branches")
    public ResponseEntity<List<BranchDTO>> getAllBranches(Pageable pageable) {
        final Page<BranchDTO> page = branchRepository.findAll(pageable).map(BranchDTO::new);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/batch/status")
    public ResponseEntity<List<TrackerDTO>> getAllStatus(Pageable pageable) {
        final Page<TrackerDTO> page = statusRepository.findAll(pageable).map(TrackerDTO::new);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody BatchDTO batchDetails) {

        Batch batch = new Batch();

        batch.setName(batchDetails.getName());
        batch.setBatchStatus("Open");
        batch.setDescription(batchDetails.getDescription());
        batch.setBranch(branchRepository.getOne(batchDetails.getBranch().getId()));
        batch.setStatus(statusRepository.getOne(batchDetails.getStatus().getId()));

        Batch result = batchRepository.save(batch);

        batchDetails.getAccounts().forEach(accountDTO -> {
        batch.addAccount(new Account(
                accountDTO.getAccountName(),
                accountDTO.getAccountNo(),
                accountDTO.getClientCode(),
                accountDTO.getAccountType()));
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



    @PutMapping("/batch/{id}")
    public ResponseEntity<?>  updateBatch(@PathVariable(value = "id") Long batchId,
                                         @Valid @RequestBody BatchDTO batchDetails) {

        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new ResourceNotFoundException("Batch", "id", batchId));

        batch.setName(batchDetails.getName());
        batch.setBatchStatus("Closed");
        batch.setDescription(batchDetails.getDescription());
        //batch.setStatus(statusRepository.getOne(batchDetails.getStatus()));

        Batch updatedBatch = batchRepository.save(batch);

        Tran transactions = new Tran();
        transactions.setBatchId(batch.getId());
        transactions.setCreatedDate(new Date());
        transactions.setStatusId(batch.getStatus().getId());
        transactions.setCreatedBy("Frank");
        transactions.setComments("initial request");
        tranRepository.save(transactions);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/batch")
                .buildAndExpand(updatedBatch.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Batch Updated successfully"));
    }


}




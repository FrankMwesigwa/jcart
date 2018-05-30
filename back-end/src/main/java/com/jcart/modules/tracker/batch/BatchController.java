package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.Tran.Tran;
import com.jcart.modules.tracker.Tran.TranRepository;
import com.jcart.modules.tracker.account.Account;
import com.jcart.modules.tracker.account.AccountRepository;
import com.jcart.modules.tracker.branch.BranchDTO;
import com.jcart.modules.tracker.branch.BranchRepository;
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
    private AccountRepository accountRepository;
    private BranchRepository branchRepository;
    private TranRepository tranRepository;

    public BatchController(BatchRepository batchRepository , BranchRepository branchRepository,
                           AccountRepository accountRepository ,TranRepository tranRepository) {
        this.batchRepository = batchRepository;
        this.branchRepository = branchRepository;
        this.accountRepository = accountRepository;
        this.tranRepository = tranRepository;
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

        Batch savebatch = new Batch();

        savebatch.setName(batchDetails.getName());
        savebatch.setDescription(batchDetails.getDescription());
        savebatch.setBranch(branchRepository.getOne(batchDetails.getBranch()));

        Batch result = batchRepository.save(savebatch);
        Set<Account> accounts = new HashSet<>();

        if (batchDetails.getAccounts() != null) {
            for (Account account : batchDetails.getAccounts()) {
                Account acnt = new Account();
                acnt.setBatchId(savebatch.getId());
                acnt.setAccountName(account.getAccountName());
                acnt.setAccountNo(account.getAccountNo());
                acnt.setAccountType(account.getAccountType());
                acnt.setClientCode(account.getClientCode());

                accounts.add(acnt);
                accountRepository.save(account);
            }
        }

        Tran transactions = new Tran();
        transactions.setBatchId(savebatch.getId());
        transactions.setCreatedDate(new Date());
        transactions.setCreatedBy("Frank");
        transactions.setComments("initial request");
        tranRepository.save(transactions);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/batch")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Batch created successfully"));
    }


}

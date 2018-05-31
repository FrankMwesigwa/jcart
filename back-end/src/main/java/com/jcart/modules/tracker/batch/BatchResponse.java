package com.jcart.modules.tracker.batch;

import com.jcart.modules.security.users.UserResponse;
import com.jcart.modules.tracker.account.AccountDTO;
import com.jcart.modules.tracker.branch.Branch;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class BatchResponse {

    private Long id;
    private String name;
    private String description;
    private Branch branch;
    private UserResponse createdBy;
    private Instant creationDate;
    private List<AccountDTO> accounts;

    public BatchResponse () {

    }

    public BatchResponse(Long id, String name, String description , UserResponse createdBy,
                         Branch branch, Instant creationDate, List<AccountDTO> accounts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.branch = branch;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.accounts = accounts;
    }
}

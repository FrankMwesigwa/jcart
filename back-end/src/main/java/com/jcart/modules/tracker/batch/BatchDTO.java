package com.jcart.modules.tracker.batch;
import com.jcart.modules.tracker.account.Account;
import com.jcart.modules.tracker.branch.Branch;
import com.jcart.modules.tracker.status.TrackerStatus;
import lombok.Data;

import java.util.List;

@Data
public class BatchDTO {

    private Long id;
    private String name;
    private String batchStatus;
    private String description;
    private Long branch;
    private Long status;
    private String branchName;
    private List<Account> accounts;

    public BatchDTO(){}

    public BatchDTO (Batch batch) {
        this(
                batch.getId(),
                batch.getName(),
                batch.getBatchStatus(),
                batch.getDescription(),
                batch.getBranch().getId(),
                batch.getStatus().getId(),
                batch.getBranch().getName()
        );
    }

    public BatchDTO(Long id, String name, String batchStatus, String description,
                    Long branch,Long status,String branchName) {

        this.id = id;
        this.name = name;
        this.batchStatus = batchStatus;
        this.description = description;
        this.branch = branch;
        this.status = status;
        this.branchName = branchName;

    }

}

package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.account.Account;
import lombok.Data;

import java.util.Set;

@Data
public class BatchDTO {

    private Long id;
    private Long branch;
    private Long batch;
    private String name;
    private String description;
    private Set<Account> accounts;

    public BatchDTO() {
    }

    public BatchDTO(Long id, Long branch, Long batch, String name, String description, Set<Account> accounts) {
        this.id = id;
        this.branch = branch;
        this.batch = batch;
        this.name = name;
        this.description = description;
        this.accounts = accounts;
    }

}

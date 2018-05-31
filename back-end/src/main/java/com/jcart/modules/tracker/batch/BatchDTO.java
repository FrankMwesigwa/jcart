package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.account.Account;
import lombok.Data;

import java.util.List;

@Data
public class BatchDTO {

    private Long id;
    private Long branch;
    private Long status;
    private Long batch;
    private String name;
    private String batchStatus;
    private String description;
    private List<Account> accounts;

}

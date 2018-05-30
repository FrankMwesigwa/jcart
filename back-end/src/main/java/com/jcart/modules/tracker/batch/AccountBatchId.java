package com.jcart.modules.tracker.batch;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class AccountBatchId {

    @Id
    @Column(name = "batchId")
    private Long accountBatch;
}

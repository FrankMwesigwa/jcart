package com.jcart.modules.tracker.account;

import com.jcart.modules.tracker.batch.Batch;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String accountName;
    private String accountNo;
    private String clientCode;
    private String accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    public Account() {

    }

    public Account(String accountName , String accountNo, String clientCode, String accountType) {
        this.accountName = accountName;
        this.accountNo = accountNo;
        this.clientCode = clientCode;
        this.accountType = accountType;
    }

}

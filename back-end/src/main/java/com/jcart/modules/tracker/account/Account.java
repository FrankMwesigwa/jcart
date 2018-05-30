package com.jcart.modules.tracker.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String accountName;
    private String accountNo;
    private String clientCode;
    private String accountType;

    @Column(name="batch_id")
    private Long batchId;

}

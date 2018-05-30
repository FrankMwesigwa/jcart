package com.jcart.modules.tracker.batch;

import com.jcart.modules.security.users.audit.UserDateAudit;
import com.jcart.modules.tracker.Tran.Tran;
import com.jcart.modules.tracker.account.Account;
import com.jcart.modules.tracker.branch.Branch;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "batch")
public class Batch extends UserDateAudit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "branchid", referencedColumnName = "id")
    private Branch branch;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "batchId")
    private Set<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "batchId")
    private Set<Tran> trans;

}

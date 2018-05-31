package com.jcart.modules.tracker.batch;

import com.jcart.modules.security.users.audit.UserDateAudit;
import com.jcart.modules.tracker.Tran.Tran;
import com.jcart.modules.tracker.account.Account;
import com.jcart.modules.tracker.branch.Branch;
import com.jcart.modules.tracker.status.TrackerStatus;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "batch")
public class Batch extends UserDateAudit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Long id;

    private String name;
    private String batchStatus;
    private String description;

    @ManyToOne
    @JoinColumn(name = "branchid", referencedColumnName = "id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private TrackerStatus status;

    @OneToMany(
            mappedBy = "batch",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "batchId")
    private List<Tran> trans;

    public void addAccount(Account account) {
        accounts.add(account);
        account.setBatch(this);
    }

}

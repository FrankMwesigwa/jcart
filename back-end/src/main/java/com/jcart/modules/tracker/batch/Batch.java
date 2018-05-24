package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.branch.Branch;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "branchid", referencedColumnName = "id")
    private Branch branch;

}

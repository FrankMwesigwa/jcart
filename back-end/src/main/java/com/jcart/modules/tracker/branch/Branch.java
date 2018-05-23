package com.jcart.modules.tracker.branch;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String branchName;
    private String description;

    public Branch() {
    }

}

package com.jcart.modules.tracker.branch;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String branchname;
    private String description;

    public Branch() {
    }

}

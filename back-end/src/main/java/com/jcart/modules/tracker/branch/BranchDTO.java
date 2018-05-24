package com.jcart.modules.tracker.branch;

import lombok.Data;

@Data
public class BranchDTO {

    private Long id;
    private String branchname;

    public BranchDTO() {
    }

    public BranchDTO(Long id, String branchname) {
        this.id = id;
        this.branchname = branchname;
    }
}

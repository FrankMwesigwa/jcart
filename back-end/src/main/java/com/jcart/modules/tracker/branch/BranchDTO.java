package com.jcart.modules.tracker.branch;

import lombok.Data;

@Data
public class BranchDTO {

    private Long id;
    private String name;

    public BranchDTO(){}

    public BranchDTO (Branch branch) {
        this(
                branch.getId(),
                branch.getName()
        );
    }

    public BranchDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

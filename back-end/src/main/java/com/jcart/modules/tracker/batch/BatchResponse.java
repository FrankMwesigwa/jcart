package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.branch.Branch;
import lombok.Data;

@Data
public class BatchResponse {

    private Long id;
    private Branch branch;
    private String name;
    private String description;

    public BatchResponse() {
    }

    public BatchResponse(Long id, Branch branch, String name, String description) {
        this.id = id;
        this.branch = branch;
        this.name = name;
        this.description = description;
    }
}

package com.jcart.modules.tracker.batch;

import com.jcart.modules.tracker.status.Status;
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
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Batch() {
    }

    public Batch(String name, String description, Status status) {
        super();
        this.name = name;
        this.description = description;
        this.status = status;
    }

}

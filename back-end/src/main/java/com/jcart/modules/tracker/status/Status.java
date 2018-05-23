package com.jcart.modules.tracker.status;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String statusName;
    private String description;
    private Date createdAt;

    public Status() {
    }

    public Status(String statusName, String description, Date createdAt) {
        super();
        this.statusName = statusName;
        this.description = description;
        this.createdAt = createdAt;
    }
}

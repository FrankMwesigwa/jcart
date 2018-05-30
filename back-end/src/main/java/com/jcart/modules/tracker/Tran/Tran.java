package com.jcart.modules.tracker.Tran;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "transactions")
public class Tran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;
    private String createdBy;
    private String status;
    private String comments;

    @Column(name="batch_id")
    private Long batchId;
}

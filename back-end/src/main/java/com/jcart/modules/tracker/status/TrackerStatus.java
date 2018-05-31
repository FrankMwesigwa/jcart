package com.jcart.modules.tracker.status;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TrackerStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TrackerStatus() {
    }



}

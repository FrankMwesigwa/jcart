package com.jcart.modules.tracker.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

}


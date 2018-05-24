package com.jcart.modules.tracker.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query("SELECT new com.jcart.modules.tracker.batch.BatchResponse(u.id, u.branch,u.name, u.description) FROM Batch u")
    List<BatchResponse> retrieveBatchResponse();

}


package com.jcart.modules.tracker.batch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    Page<Batch> findAll(Pageable pageable);

    @Query("SELECT new com.jcart.modules.tracker.batch.BatchDTO(u.id, u.branch, u.name,u.description) FROM Batch u")
    List<BatchDTO> retrieveBatchAsDTO();
}


package com.jcart.modules.tracker.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerStatusRepository extends JpaRepository<TrackerStatus, Long> {

}



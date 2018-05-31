package com.jcart.modules.tracker.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackerStatusRepository extends JpaRepository<TrackerStatus, Long> {

    @Query("SELECT new com.jcart.modules.tracker.status.TrackerResponse(u.id, u.name) FROM TrackerStatus u")
    List<TrackerResponse> getTrackerResponse();
}



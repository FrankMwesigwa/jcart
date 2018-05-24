package com.jcart.modules.tracker.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("SELECT new com.jcart.modules.tracker.branch.BranchDTO(u.id, u.branchname) FROM Branch u")
    List<BranchDTO> retrieveBranchDTO();

}

package com.jcart.modules.tracker.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

}

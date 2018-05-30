package com.jcart.modules.tracker.Tran;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranRepository extends JpaRepository<Tran, Long> {

}

package com.levysales.FinanceAPI.domain.repository;

import com.levysales.FinanceAPI.domain.model.Outgoing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingRepository extends JpaRepository<Outgoing, Long> {
}



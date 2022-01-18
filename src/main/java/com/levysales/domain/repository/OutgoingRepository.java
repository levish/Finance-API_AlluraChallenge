package com.levysales.domain.repository;

import com.levysales.domain.model.Income;
import com.levysales.domain.model.Outgoing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingRepository extends JpaRepository<Outgoing, Long> {
}



package com.levysales.FinanceAPI.domain.repository;

import com.levysales.FinanceAPI.domain.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
}



package com.texaculture.expensemanage.ReimbursementHistory.reprository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texaculture.expensemanage.ReimbursementHistory.entity.ReimbursementHistory;

@Repository
public interface ReimbursementHistoryRepository extends JpaRepository<ReimbursementHistory, Long> {

	List<ReimbursementHistory> findAll();
}

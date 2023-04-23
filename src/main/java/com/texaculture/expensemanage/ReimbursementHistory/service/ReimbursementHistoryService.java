package com.texaculture.expensemanage.ReimbursementHistory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texaculture.expensemanage.ReimbursementHistory.entity.ReimbursementHistory;
import com.texaculture.expensemanage.ReimbursementHistory.reprository.ReimbursementHistoryRepository;

@Service
public class ReimbursementHistoryService {
	@Autowired
    private ReimbursementHistoryRepository reimbursementHistoryRepository;

    public List<ReimbursementHistory> getAllReimbursementHistory() {
        return reimbursementHistoryRepository.findAll();
    }

    public Optional<ReimbursementHistory> getReimbursementHistoryById(Long id) {
        return reimbursementHistoryRepository.findById(id);
    }

    public ReimbursementHistory saveReimbursementHistory(ReimbursementHistory reimbursementHistory) {
        return reimbursementHistoryRepository.save(reimbursementHistory);
    }

    public void deleteReimbursementHistoryById(Long id) {
        reimbursementHistoryRepository.deleteById(id);
    }
}

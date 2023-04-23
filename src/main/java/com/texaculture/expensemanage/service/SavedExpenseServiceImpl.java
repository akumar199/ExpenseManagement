package com.texaculture.expensemanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texaculture.expensemanage.entity.SavedExpense;
import com.texaculture.expensemanage.reprository.SavedExpenseRepository;

@Service
public class SavedExpenseServiceImpl implements SavedExpenseService {
	@Autowired
    private SavedExpenseRepository savedExpenseRepository;

    @Override
    public List<SavedExpense> getAllSavedExpenses() {
        return savedExpenseRepository.findAll();
    }

    @Override
    public SavedExpense getSavedExpenseById(Long id) {
        return savedExpenseRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public SavedExpense saveSavedExpense(SavedExpense savedExpense) {
        return savedExpenseRepository.save(savedExpense);
    }

    @Override
    public SavedExpense updateSavedExpense(Long id, SavedExpense savedExpense) {
        SavedExpense existingSavedExpense = savedExpenseRepository.findById(id)
                .orElseThrow();

        existingSavedExpense.setClaimDate(savedExpense.getClaimDate());
        existingSavedExpense.setReimbursementMonth(savedExpense.getReimbursementMonth());
        existingSavedExpense.setClaimedAmount(savedExpense.getClaimedAmount());
        existingSavedExpense.setStatus(savedExpense.getStatus());

        return savedExpenseRepository.save(existingSavedExpense);
    }

    @Override
    public void deleteSavedExpense(Long id) {
        savedExpenseRepository.deleteById(id);
    }
}

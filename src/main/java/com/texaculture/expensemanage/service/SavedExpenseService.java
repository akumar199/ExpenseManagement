package com.texaculture.expensemanage.service;

import java.util.List;

import com.texaculture.expensemanage.entity.SavedExpense;

public interface SavedExpenseService {
	List<SavedExpense> getAllSavedExpenses();

    SavedExpense getSavedExpenseById(Long id);

    SavedExpense saveSavedExpense(SavedExpense savedExpense);

    SavedExpense updateSavedExpense(Long id, SavedExpense savedExpense);

    void deleteSavedExpense(Long id);
}

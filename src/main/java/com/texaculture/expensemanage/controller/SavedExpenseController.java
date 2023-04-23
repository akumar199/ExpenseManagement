package com.texaculture.expensemanage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texaculture.expensemanage.entity.SavedExpense;
import com.texaculture.expensemanage.service.SavedExpenseService;

@RestController
@RequestMapping("/saved-expenses")
public class SavedExpenseController {

    @Autowired
    private SavedExpenseService savedExpenseService;

    @GetMapping("")
    public List<SavedExpense> getAllSavedExpenses() {
        return savedExpenseService.getAllSavedExpenses();
    }

    @GetMapping("/{id}")
    public SavedExpense getSavedExpenseById(@PathVariable(value = "id") Long id) {
        return savedExpenseService.getSavedExpenseById(id);
    }

    @PostMapping("")
    public SavedExpense createSavedExpense(@Valid @RequestBody SavedExpense savedExpense) {
        return savedExpenseService.saveSavedExpense(savedExpense);
    }

    @PutMapping("/{id}")
    public SavedExpense updateSavedExpense(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody SavedExpense savedExpense) {
        return savedExpenseService.updateSavedExpense(id, savedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSavedExpense(@PathVariable(value = "id") Long id) {
        savedExpenseService.deleteSavedExpense(id);
        return ResponseEntity.ok().build();
    }
}

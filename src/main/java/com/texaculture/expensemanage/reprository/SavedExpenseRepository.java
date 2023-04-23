package com.texaculture.expensemanage.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.texaculture.expensemanage.entity.SavedExpense;

@Repository
@EnableJpaRepositories
public interface SavedExpenseRepository extends JpaRepository<SavedExpense, Long> {
}
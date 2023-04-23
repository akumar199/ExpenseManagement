package com.texaculture.expensemanage.ReimbursementHistory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texaculture.expensemanage.ReimbursementHistory.entity.ReimbursementHistory;
import com.texaculture.expensemanage.ReimbursementHistory.service.ReimbursementHistoryService;
@RestController
@RequestMapping("/reimbursement-history")
public class ReimbursementHistoryController {
	@Autowired
    private ReimbursementHistoryService reimbursementHistoryService;

    @GetMapping
    public ResponseEntity<List<ReimbursementHistory>> getAllReimbursementHistory() {
        List<ReimbursementHistory> reimbursementHistoryList = reimbursementHistoryService.getAllReimbursementHistory();
        return new ResponseEntity<>(reimbursementHistoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReimbursementHistory> getReimbursementHistoryById(@PathVariable("id") Long id) {
        Optional<ReimbursementHistory> reimbursementHistoryOptional = reimbursementHistoryService.getReimbursementHistoryById(id);
        return reimbursementHistoryOptional.map(reimbursementHistory -> new ResponseEntity<>(reimbursementHistory, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReimbursementHistory> saveReimbursementHistory(@RequestBody ReimbursementHistory reimbursementHistory) {
        ReimbursementHistory savedReimbursementHistory = reimbursementHistoryService.saveReimbursementHistory(reimbursementHistory);
        return new ResponseEntity<>(savedReimbursementHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReimbursementHistory> updateReimbursementHistoryById(@PathVariable("id") Long id,
                                                                                @RequestBody ReimbursementHistory reimbursementHistory) {
        Optional<ReimbursementHistory> reimbursementHistoryOptional = reimbursementHistoryService.getReimbursementHistoryById(id);
        if (reimbursementHistoryOptional.isPresent()) {
            ReimbursementHistory existingReimbursementHistory = reimbursementHistoryOptional.get();
            existingReimbursementHistory.setMonthOfReimbursement(reimbursementHistory.getMonthOfReimbursement());
            existingReimbursementHistory.setDateOfClaim(reimbursementHistory.getDateOfClaim());
            existingReimbursementHistory.setClaimedAmount(reimbursementHistory.getClaimedAmount());
            existingReimbursementHistory.setApprovedAmount(reimbursementHistory.getApprovedAmount());
            existingReimbursementHistory.setPaidAmount(reimbursementHistory.getPaidAmount());
            existingReimbursementHistory.setPaymentDate(reimbursementHistory.getPaymentDate());
            ReimbursementHistory updatedReimbursementHistory = reimbursementHistoryService.saveReimbursementHistory(existingReimbursementHistory);
            return new ResponseEntity<>(updatedReimbursementHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReimbursementHistoryById(@PathVariable("id") Long id) {
        Optional<ReimbursementHistory> reimbursementHistoryOptional = reimbursementHistoryService.getReimbursementHistoryById(id);
        if (reimbursementHistoryOptional.isPresent()) {
            reimbursementHistoryService.deleteReimbursementHistoryById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

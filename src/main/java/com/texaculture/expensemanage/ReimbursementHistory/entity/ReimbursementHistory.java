package com.texaculture.expensemanage.ReimbursementHistory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity

public class ReimbursementHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String monthOfReimbursement;

   
    private LocalDate dateOfClaim;

   
    private BigDecimal claimedAmount;

   
    private BigDecimal approvedAmount;

   
    private BigDecimal paidAmount;

    
    private LocalDate paymentDate;

    public ReimbursementHistory() {
    }

    public ReimbursementHistory(String monthOfReimbursement, LocalDate dateOfClaim, BigDecimal claimedAmount,
                                BigDecimal approvedAmount, BigDecimal paidAmount, LocalDate paymentDate) {
        this.monthOfReimbursement = monthOfReimbursement;
        this.dateOfClaim = dateOfClaim;
        this.claimedAmount = claimedAmount;
        this.approvedAmount = approvedAmount;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonthOfReimbursement() {
        return monthOfReimbursement;
    }

    public void setMonthOfReimbursement(String monthOfReimbursement) {
        this.monthOfReimbursement = monthOfReimbursement;
    }

    public LocalDate getDateOfClaim() {
        return dateOfClaim;
    }

    public void setDateOfClaim(LocalDate dateOfClaim) {
        this.dateOfClaim = dateOfClaim;
    }

    public BigDecimal getClaimedAmount() {
        return claimedAmount;
    }

    public void setClaimedAmount(BigDecimal claimedAmount) {
        this.claimedAmount = claimedAmount;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}

package com.texaculture.expensemanage.entity;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SavedExpense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate claimDate;

    @NotNull
    private LocalDate reimbursementMonth;

    @NotNull
    private Double claimedAmount;

    @NotNull
    private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public LocalDate getReimbursementMonth() {
		return reimbursementMonth;
	}

	public void setReimbursementMonth(LocalDate reimbursementMonth) {
		this.reimbursementMonth = reimbursementMonth;
	}

	public Double getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(Double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SavedExpense(Long id, @NotNull LocalDate claimDate, @NotNull LocalDate reimbursementMonth,
			@NotNull Double claimedAmount, @NotNull String status) {
		super();
		this.id = id;
		this.claimDate = claimDate;
		this.reimbursementMonth = reimbursementMonth;
		this.claimedAmount = claimedAmount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "SavedExpense [id=" + id + ", claimDate=" + claimDate + ", reimbursementMonth=" + reimbursementMonth
				+ ", claimedAmount=" + claimedAmount + ", status=" + status + "]";
	}

	public SavedExpense() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

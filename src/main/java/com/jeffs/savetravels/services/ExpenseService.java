package com.jeffs.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffs.savetravels.models.Expense;
import com.jeffs.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expRepo;
	
	public List<Expense> allExpenses(){
		return expRepo.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expRepo.save(e);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExp = expRepo.findById(id);
		if(optionalExp.isPresent()) {
			return optionalExp.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense e) {
		return expRepo.save(e);
	}
	
	public void deleteExpense(Long id) {
		expRepo.deleteById(id);
	}
}

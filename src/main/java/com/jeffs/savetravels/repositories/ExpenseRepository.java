package com.jeffs.savetravels.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffs.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	//find all Expenses
	List<Expense> findAll();
	//find individual expense by id
	Optional<Expense> findById(Long search);
	
}

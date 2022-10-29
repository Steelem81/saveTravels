package com.jeffs.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jeffs.savetravels.models.Expense;
import com.jeffs.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expServ;
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense")Expense expense, Model model) {
		model.addAttribute("allExpenses", expServ.allExpenses());
		return "index.jsp";
	}
	
	@PostMapping("/expense/create")
		public String createExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
			expServ.createExpense(expense);
			return "redirect:/expenses";
		}
	
	@GetMapping("/expense/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expServ.findExpense(id));
		return "edit.jsp";
	}
	
	@PutMapping("/expense/{id}/edit")
	public String update(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("had errors");
			return "edit.jsp";
		} else {
			System.out.println("saved");
			expServ.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expense/{id}/delete")
	public String delete(@PathVariable(name="id")Long id) {
		expServ.deleteExpense(id);
		return "redirect:/expenses";
	}

}

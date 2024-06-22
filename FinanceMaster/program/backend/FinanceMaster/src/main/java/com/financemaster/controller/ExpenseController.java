package com.financemaster.controller;

import com.financemaster.model.Expense;
import com.financemaster.model.User;
import com.financemaster.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController
{
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public List<Expense> getAllExpenses(@AuthenticationPrincipal User user)
    {
        return expenseService.getExpensesByUser(user);
    }

    @PostMapping("/")
    public Expense addExpense(@RequestBody Expense expense, @AuthenticationPrincipal User user)
    {
        expense.setUser(user);
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id)
    {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id)
    {
        expenseService.deleteExpense(id);
    }
}
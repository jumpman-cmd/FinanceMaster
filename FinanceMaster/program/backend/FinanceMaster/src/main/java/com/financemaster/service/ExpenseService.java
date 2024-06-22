package com.financemaster.service;

import com.financemaster.dao.ExpenseRepository;
import com.financemaster.model.Expense;
import com.financemaster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService
{
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense)
    {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(User user)
    {
        return expenseRepository.findByUser(user);
    }

    public Expense getExpenseById(Long id)
    {
        return expenseRepository.findById(id).orElse(null);
    }

    public void deleteExpense(Long id)
    {
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Expense expense)
    {

        return expense;
    }

    public List<Expense> getAllExpenses()
    {
        return null;
    }

    public Expense addExpense(Expense expense)
    {
        return expense;
    }
}
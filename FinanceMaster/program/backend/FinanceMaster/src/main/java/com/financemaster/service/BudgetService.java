package com.financemaster.service;

import com.financemaster.dao.BudgetRepository;
import com.financemaster.model.Budget;
import com.financemaster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService
{
    @Autowired
    private BudgetRepository budgetRepository;

    public Budget addBudget(Budget budget)
    {
        return budgetRepository.save(budget);
    }

    public List<Budget> getBudgetsByUser(User user)
    {
        return budgetRepository.findByUser(user);
    }

    public List<Budget> getBudgetsByUserAndCategory(User user, String category)
    {
        return budgetRepository.findByUserAndCategory(user, category);
    }

    public Budget updateBudget(Budget budget)
    {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long budgetId)
    {
        budgetRepository.deleteById(budgetId);
    }
}
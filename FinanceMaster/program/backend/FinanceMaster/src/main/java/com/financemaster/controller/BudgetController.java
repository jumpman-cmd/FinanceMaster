package com.financemaster.controller;

import com.financemaster.model.Budget;
import com.financemaster.model.User;
import com.financemaster.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/")
    public Budget addBudget(@RequestBody Budget budget, @AuthenticationPrincipal User user) {
        budget.setUser(user);
        return budgetService.addBudget(budget);
    }

    @GetMapping("/")
    public List<Budget> getBudgets(@AuthenticationPrincipal User user) {
        return budgetService.getBudgetsByUser(user);
    }

    @GetMapping("/{category}")
    public List<Budget> getBudgetsByCategory(@AuthenticationPrincipal User user, @PathVariable String category) {
        return budgetService.getBudgetsByUserAndCategory(user, category);
    }

    @PutMapping("/")
    public Budget updateBudget(@RequestBody Budget budget) {
        return budgetService.updateBudget(budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }
}
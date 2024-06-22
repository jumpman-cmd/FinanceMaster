package com.financemaster.service;

import com.financemaster.dao.BudgetRepository;
import com.financemaster.model.Budget;
import com.financemaster.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BudgetServiceTest {

    @Mock
    private BudgetRepository budgetRepository;

    @InjectMocks
    private BudgetService budgetService;

    private User user;
    private Budget budget;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
        budget = new Budget(user, "Groceries", new BigDecimal("500.00"), LocalDate.now(), LocalDate.now().plusMonths(1));
    }

    @Test
    void testAddBudget() {
        when(budgetRepository.save(budget)).thenReturn(budget);
        Budget savedBudget = budgetService.addBudget(budget);
        assertNotNull(savedBudget);
        assertEquals(budget.getCategory(), savedBudget.getCategory());
    }

    @Test
    void testGetBudgetsByUser() {
        List<Budget> budgets = Arrays.asList(budget);
        when(budgetRepository.findByUser(user)).thenReturn(budgets);
        List<Budget> retrievedBudgets = budgetService.getBudgetsByUser(user);
        assertEquals(1, retrievedBudgets.size());
    }

    @Test
    void testUpdateBudget() {
        budget.setAmount(new BigDecimal("600.00"));
        when(budgetRepository.save(budget)).thenReturn(budget);
        Budget updatedBudget = budgetService.updateBudget(budget);
        assertEquals(new BigDecimal("600.00"), updatedBudget.getAmount());
    }

    @Test
    void testDeleteBudget() {
        doNothing().when(budgetRepository).deleteById(budget.getId());
        budgetService.deleteBudget(budget.getId());
        verify(budgetRepository, times(1)).deleteById(budget.getId());
    }
}
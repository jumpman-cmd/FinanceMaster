package com.financemaster.service;

import com.financemaster.dao.ExpenseRepository;
import com.financemaster.model.Expense;
import com.financemaster.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ExpenseServiceTest
{
    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    private User testUser;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        testUser = new User(); // Mock or actual user setup
    }

    @Test
    public void testAddExpense()
    {
        // Create an expense
        Expense expense = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());

        // Mock behavior of repository.save()
        when(expenseRepository.save(expense)).thenReturn(expense);

        // Call the service method to add the expense
        Expense savedExpense = expenseService.addExpense(expense);

        // Verify the save operation
        Assertions.assertNotNull(savedExpense.getId());
        verify(expenseRepository, times(1)).save(expense);
    }

    @Test
    public void testGetAllExpenses()
    {
        // Mock behavior of repository.findAll()
        when(expenseRepository.findAll()).thenReturn(List.of(new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now())));

        // Call the service method to retrieve all expenses
        List<Expense> expenses = expenseService.getAllExpenses();

        // Verify that expenses were retrieved correctly
        Assertions.assertFalse(expenses.isEmpty());
        verify(expenseRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateExpense()
    {
        // Create an expense
        Expense expense = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());

        // Mock behavior of repository.save()
        when(expenseRepository.save(expense)).thenReturn(expense);

        // Call the service method to update the expense
        Expense updatedExpense = expenseService.updateExpense(expense);

        // Verify the update operation
        Assertions.assertEquals(expense.getDescription(), updatedExpense.getDescription());
        verify(expenseRepository, times(1)).save(expense);
    }

    @Test
    public void testDeleteExpense()
    {
        // Create an expense
        Expense expense = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());

        // Call the service method to delete the expense
        expenseService.deleteExpense(expense.getId());

        // Verify that delete method of repository is called
        verify(expenseRepository, times(1)).delete(expense);
    }
}
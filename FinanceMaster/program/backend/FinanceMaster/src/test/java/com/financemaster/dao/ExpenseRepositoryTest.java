package com.financemaster.dao;

import com.financemaster.model.Expense;
import com.financemaster.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ExpenseRepositoryTest
{

    @Autowired
    private ExpenseRepository expenseRepository;

    private User testUser;

    @BeforeEach
    public void setUp()
    {
        testUser = new User(); // Mock or actual user setup
    }

    @Test
    public void testSaveExpense()
    {
        // Create an expense
        Expense expense = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());

        // Save the expense
        Expense savedExpense = expenseRepository.save(expense);

        // Verify save operation
        Assertions.assertNotNull(savedExpense.getId());
        Assertions.assertEquals(expense.getUser(), savedExpense.getUser());
    }

    @Test
    public void testFindAllExpenses()
    {
        // Create some expenses for testing
        Expense expense1 = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());
        Expense expense2 = new Expense(testUser, "Utilities", new BigDecimal("100.00"), "Electricity bill", LocalDate.now().minusDays(1));

        // Save expenses to database
        expenseRepository.save(expense1);
        expenseRepository.save(expense2);

        // Retrieve all expenses from repository
        List<Expense> allExpenses = expenseRepository.findAll();

        // Verify that expenses were retrieved correctly
        Assertions.assertEquals(2, allExpenses.size());
    }

    @Test
    public void testUpdateExpense()
    {
        // Create and save an expense
        Expense expense = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());
        Expense savedExpense = expenseRepository.save(expense);

        // Modify the expense
        savedExpense.setDescription("Monthly groceries");
        expenseRepository.save(savedExpense); // Update the expense

        // Retrieve the updated expense from repository
        Optional<Expense> updatedExpense = expenseRepository.findById(savedExpense.getId());

        // Verify the update operation
        Assertions.assertTrue(updatedExpense.isPresent());
        Assertions.assertEquals("Monthly groceries", updatedExpense.get().getDescription());
    }

    @Test
    public void testDeleteExpense()
    {
        // Create and save an expense
        Expense expense = new Expense(testUser, "Groceries", new BigDecimal("50.00"), "Weekly groceries", LocalDate.now());
        Expense savedExpense = expenseRepository.save(expense);

        // Delete the expense from repository
        expenseRepository.delete(savedExpense);

        // Try to retrieve the deleted expense from repository
        Optional<Expense> deletedExpense = expenseRepository.findById(savedExpense.getId());

        // Verify that expense is deleted
        Assertions.assertFalse(deletedExpense.isPresent());
    }
}
package com.financemaster.dao;

import com.financemaster.model.Expense;
import com.financemaster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>
{
    List<Expense> findByUser(User user);
}
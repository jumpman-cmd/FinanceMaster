package com.financemaster.dao;

import com.financemaster.model.Budget;
import com.financemaster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long>
{
    List<Budget> findByUser(User user);
    List<Budget> findByUserAndCategory(User user, String category);
}
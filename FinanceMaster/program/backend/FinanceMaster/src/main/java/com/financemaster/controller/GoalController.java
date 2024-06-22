package com.financemaster.controller;

import com.financemaster.model.Goal;
import com.financemaster.model.User;
import com.financemaster.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController
{
    @Autowired
    private GoalService goalService;

    @PostMapping("/")
    public Goal addGoal(@RequestBody Goal goal, @AuthenticationPrincipal User user)
    {
        goal.setUser(user);
        return goalService.addGoal(goal);
    }

    @GetMapping("/")
    public List<Goal> getGoals(@AuthenticationPrincipal User user)
    {
        return goalService.getGoalsByUser(user);
    }

    @PutMapping("/")
    public Goal updateGoal(@RequestBody Goal goal)
    {
        return goalService.updateGoal(goal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id)
    {
        goalService.deleteGoal(id);
    }
}
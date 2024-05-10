package se.face.evensteven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import se.face.evensteven.model.Expense;
import se.face.evensteven.repository.ExpenseRepository;

import java.util.List;

@Controller
@RequestMapping("expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/index")
    public String showExpenses(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        return "index";  // Returns the index.html Thymeleaf template
    }

    @PostMapping
    public RedirectView addExpense(Expense expense) {
        expenseRepository.save(expense);
        return new RedirectView("/expenses/index");  // Redirect to update the list of expenses
    }
}
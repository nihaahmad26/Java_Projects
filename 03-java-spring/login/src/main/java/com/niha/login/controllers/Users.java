package com.niha.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niha.login.models.Task;
import com.niha.login.models.User;
import com.niha.login.services.UserService;
import com.niha.login.validator.UserValidator;

@Controller
public class Users {
private final UserService userService;

private final UserValidator userValidator;

public Users(UserService userService, UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
}

 
 @GetMapping("/")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }

 @PostMapping(value="/registration")
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 userValidator.validate(user,  result);
	 if(result.hasErrors()) {
		 return "registrationPage.jsp";
	 }
	 User u = userService.registerUser(user);
	 session.setAttribute("userId", u.getId());
	 return "redirect:/tasks";
 }
 
 @PostMapping(value="/login")
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectt, Model viewModel, HttpSession session) {
	 boolean isAuthenticated = userService.authenticateUser(email, password);
	 if(isAuthenticated) {
		 User u = userService.findByEmail(email);
		 session.setAttribute("userId", u.getId());
		 return "redirect:/tasks";
	 }
	 redirectt.addFlashAttribute("error", "Invalid Credentials. Please try again");
	 return "redirect:/";
 }
	 
 
 @GetMapping("/tasks")
 public String home(HttpSession session, Model viewModel, @ModelAttribute("tasks") Task task, @ModelAttribute("users") User user) {
     // get user from session, save them in the model and return the home page
	 Long userId = (Long) session.getAttribute("userId");
//	 System.out.println("userID");
//	 System.out.println(userId);
	 User u = userService.findUserById(userId);
//	 System.out.println("username is: " + u.getName());
	 viewModel.addAttribute("user",u);
	 viewModel.addAttribute("alltasks", this.userService.getAllTasks());
	 viewModel.addAttribute("allusers", this.userService.getAllUsers());
	 return "homePage.jsp";
 }
 
 @GetMapping("/tasks/new")
 public String newTask(HttpSession session, Model viewModel, @ModelAttribute("task") Task task, @ModelAttribute("users") User user) {
	 viewModel.addAttribute("alltasks", this.userService.getAllTasks());
	 viewModel.addAttribute("allusers", this.userService.getAllUsers());
	 Long userId = (Long) session.getAttribute("userId");
	 User u = userService.findUserById(userId);
	 viewModel.addAttribute("user",u);
	 return "createTask.jsp";
 }
 
 @PostMapping("/task/createTask")
 public String addTask(@Valid @ModelAttribute("task") Task task, @ModelAttribute("users") User user, BindingResult result, HttpSession session, Model viewModel) {
	 if(result.hasErrors()) {
		 return "createTask.jsp";
	 }
	 Long userId = (Long) session.getAttribute("userId");
	 User u = userService.findUserById(userId);
	 this.userService.createTask(task);
	 return "redirect:/tasks";
 }
 
 @GetMapping("/tasks/{id}")
 public String view(@PathVariable("id") Long id, Model viewModel) {
	 Task task = userService.getOneTask(id);
	 viewModel.addAttribute("task", task);
	 return "viewTask.jsp";
 }
 
 @GetMapping("/edit/{id}")
 public String editTask(@ModelAttribute("task") Task task, @PathVariable("id") Long id, HttpSession session, Model viewModel) {
     viewModel.addAttribute("task",this.userService.getOneTask(id));
	 viewModel.addAttribute("allusers", this.userService.getAllUsers());
	 return "editTask.jsp";
 }
 
 @PostMapping("/task/edit/{id}") 
 public String editTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
//	 viewModel.addAttribute("task",this.userService.getOneTask(id));
	 if(result.hasErrors()) {
//		 viewModel.addAttribute("task",this.userService.getOneTask(id));
		 return "editTask.jsp";
	 }
//	 Long userId = (Long) session.getAttribute("userId");
//	 User u = userService.findUserById(userId);
//	 task.setUser(u);
	 this.userService.editTask(task);
	 return "redirect:/tasks";
 }
 
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/";
 }
 
 @GetMapping("/delete/{id}")
 public String destroy(@PathVariable("id") Long id) {
     userService.deleteTask(id);
     return "redirect:/tasks";
 }
}
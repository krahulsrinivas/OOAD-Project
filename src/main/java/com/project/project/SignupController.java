package com.project.project;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    private DBService service = new DBService();
    
  @GetMapping("/signup")
  public String signup(Model model)
  {
    User user = new User();
    model.addAttribute("user", user);
    return "signup";
  }

  @PostMapping("/signup")
  public String signup(@ModelAttribute("User") User user)
  {
    //Add user to database
    service.addUser(user.getUsername(), user.getPassword());
    return "signup";
  }
    
}


package com.project.project;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  private DBService service = new DBService();

  @GetMapping("/")
  public String login(Model model)
  {
    User user = new User();
    model.addAttribute("user", user);
    return "login";
  }

  
  @PostMapping("/")
	public String login(@ModelAttribute("User") User user)
  {
    ArrayList<User> users = service.getAllUsers();
    for(User u:users)
    {
      String db_iduser = u.getUsername();
      String db_pwduser = u.getPassword();
      System.out.println(db_iduser + db_pwduser);
      System.out.println("Input " + user.getUsername() + user.getPassword());
      if (user.getUsername().equals(db_iduser) && user.getPassword().equals(db_pwduser))
      {
        //Redirect to home page
        System.out.println("Login Succesfull!!!!!!!!!!!!!!!");
        return "redirect:/home";
      }

      //TODO: Generate alert for invalid login

      
    }
		return "login";
  }

  

  @PostMapping("/order")
  public String signup()
  {
    //Add user to database
    service.clearCart();
    return "redirect:/home";
  }




}

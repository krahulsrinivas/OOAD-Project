package com.project.project;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
    private DBService service = new DBService();
    
    @GetMapping("/cart")
    public String cart(Model model)
    {
      ArrayList<ArrayList<String>> items = service.getAllItems();
      System.out.println(items);
      model.addAttribute("user", items);
      return "cart";
    }
  
  @PostMapping("/cart")
  public String cart(@ModelAttribute("item") item item)
  {
    //Add user to database
      System.out.println(item.getname());
      System.out.println(item.getcost());
      System.out.println(item.getimage());
      service.addItem(item.getname(), Integer.parseInt(item.getcost()),item.getimage());
      return "index";
  }
    
}


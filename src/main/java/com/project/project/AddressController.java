package com.project.project;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {
    private DBService service = new DBService();
    
    @GetMapping("/address")
  public String address()
  {
    return "address";
  }

  @PostMapping("/address")
  public String address(@ModelAttribute("address") Address address,Model model)
  {
    //Add user to database
    ArrayList<String> addres = new ArrayList<String>();
    addres.add(address.getstreet());
    addres.add(address.getcity());
    addres.add(address.getstate());
    addres.add(address.getzip());
    addres.add(address.getcontactno());
    ArrayList<ArrayList<String>> items = service.getAllItems();
    model.addAttribute("address", addres);
    model.addAttribute("items", items);
    return "bill";
  }
    
}


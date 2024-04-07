package com.webapp.springdemo.controller;


import com.webapp.springdemo.dao.CustomerDAO;
import com.webapp.springdemo.entity.Customer;
import com.webapp.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model theModel){
        List<Customer> customerList=customerService.getCustomers();
        theModel.addAttribute("customers",customerList);
        return "list-customers";
    }
    @RequestMapping("showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer theCustomer=new Customer();
        theModel.addAttribute("theCustomer",theCustomer);
        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("theCustomer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        Customer theCustomer=customerService.getCustomer(theId);
        theModel.addAttribute("theCustomer",theCustomer);
        return "customer-form";
    }
    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int id,Model theModel){
        customerService.delete(id);
        return "redirect:/customer/list";
    }


}

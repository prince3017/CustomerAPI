package com.prince.controller;

import com.prince.entity.Customer;
import com.prince.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // handler method to handle list customers and return mode and view
    @GetMapping("/customers")
    public String listCustomer(Model model, String keyword) {
        if(keyword != null){
            model.addAttribute("customers",customerService.findByKeyword(keyword));
        }else{
            model.addAttribute("customers", customerService.getAllCustomer());
        }
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomerForm(Model model) {

        // create Customer object to hold Customer form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";

    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id,
                                 @ModelAttribute("customer") Customer customer,
                                 Model model) {

        // get Customer from database by id
        Customer existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setStreet(customer.getStreet());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        // save updated Customer object
        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

    // handler method to handle delete Customer request

    @GetMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }



}

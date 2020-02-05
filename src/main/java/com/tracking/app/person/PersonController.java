package com.tracking.app.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping({"/", "/person"})
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/person")
    public String personSubmit(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "result";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("records",personService.getAllRecords());
        return "list";
    }
}

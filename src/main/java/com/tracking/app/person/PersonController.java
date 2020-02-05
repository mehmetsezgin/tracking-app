package com.tracking.app.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @GetMapping("/person")
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/person")
    public String personSubmit(@ModelAttribute Person person) {
        return "result";
    }
}

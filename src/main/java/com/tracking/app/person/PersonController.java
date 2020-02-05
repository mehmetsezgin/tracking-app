package com.tracking.app.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping({"/view/{id}"})
    public String updateForm(@PathVariable String id, Model model) {
        Person personFromDb = personService.findById(Long.parseLong(id));
        model.addAttribute("person", personFromDb);
        return "view";
    }

    @GetMapping({"/delete/{id}"})
    public String delete(@PathVariable String id, Model model) {
        personService.deleteById(Long.parseLong(id));
        model.addAttribute("id", id);
        return "deleteresult";
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

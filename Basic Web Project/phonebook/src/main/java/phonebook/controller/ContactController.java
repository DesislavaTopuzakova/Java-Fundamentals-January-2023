package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    private List<Contact> contacts;

    public ContactController() {
        this.contacts = new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView index (ModelAndView modelAndView) {
        this.contacts.add(new Contact("Desi", "1234"));
        this.contacts.add(new Contact("Pesho", "123"));
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }


    @PostMapping("/")
    public String add (Contact contact) {
        this.contacts.add(contact);
        return "redirect:/";
    }

}

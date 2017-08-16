package contactlist.mahder.demo.controller;

import contactlist.mahder.demo.models.Person;
import contactlist.mahder.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {


        @Autowired
        PersonRepository personRepository;

        @RequestMapping("/")
        public String listcontacts(Model model){
            model.addAttribute("personp", personRepository.findAll());
            return "listall";
        }

        @GetMapping("/addcontact")
        public String AddContact(Model model){
            model.addAttribute("newperson", new Person());
            return "addcontact";
        }

        @PostMapping("/addcontact")
        public String processForm(@Valid @ModelAttribute("newperson") Person newperson, BindingResult bindingResult){
            if (bindingResult.hasErrors())
            {
                return "addcontact";
            }
            personRepository.save(newperson);
            return "redirect:/";
        }

        @GetMapping("/detail/{id}")
        public String showContact(@PathVariable("id") long id, Model model){
            model.addAttribute("newperson", personRepository.findOne(id));
            return "show";
        }

        @GetMapping("/update/{id}")
        public String updateContact(@PathVariable("id") long id, Model model){
            model.addAttribute("newperson", personRepository.findOne(id));
            return "addcontact";
        }

        @GetMapping("/delete/{id}")
        public String deleteContact(@PathVariable("id") long id){
            personRepository.delete(id);
            return "redirect:/";
        }
}

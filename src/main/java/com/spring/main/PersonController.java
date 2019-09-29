package com.spring.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
    @RequestMapping("/")
    public String homePageRedir(Model model) {
    	List<Person> personList = personService.listAll();
    	model.addAttribute("personList", personList);
    	
    	return "index";
    }
     
    @RequestMapping("/new")
    public String addPersonRedir(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        
        return "addPerson";
    }
 
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person) {
    	personService.save(person);
    	
    	return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView editPageRedir(@PathVariable(name = "id")int id) {
    	ModelAndView mav = new ModelAndView("updatePerson");
    	Person person = personService.get(id);
    	mav.addObject("person", person);
    	
    	return mav;
    }
         
    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name = "id")int id) {
    	personService.delete(id);
    	
    	return "redirect:/";
    }
	
	
	
	
	
}

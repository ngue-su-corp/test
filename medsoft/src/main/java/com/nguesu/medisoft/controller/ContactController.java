package com.nguesu.medisoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nguesu.medisoft.form.Contact;
import com.nguesu.medisoft.service.ContactService;

@Controller
public class ContactController {
	@Autowired
    private ContactService contactService;
 
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
 
        map.put("contact", new Contact());
        map.put("contactList", contactService.listContact());
 
        return "contact";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
    Contact contact, BindingResult result) {
 
    	if(null != contact.getId() && contact.getId() > 0){
    		contactService.updateContact(contact);
    	}else{
    		contactService.addContact(contact);
    	}
 
        return "redirect:/index";
    }
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    Integer contactId) {
 
        contactService.removeContact(contactId);
 
        return "redirect:/index";
    }
    
    @RequestMapping(value="/edit/{contactId}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer contactId) {
    	ModelAndView modelAndView = new ModelAndView("contact");
    	Contact contact = contactService.getContact(contactId);
    	modelAndView.addObject("contact",contact);
    	modelAndView.addObject("contactList", contactService.listContact());
    	return modelAndView;

    }

    
}

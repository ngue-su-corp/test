package com.nguesu.medisoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguesu.medisoft.dao.ContactDAO;
import com.nguesu.medisoft.form.Contact;
import com.nguesu.medisoft.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
    private ContactDAO contactDAO;
     
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }
 
    @Transactional
    public List<Contact> listContact() {
 
        return contactDAO.listContact();
    }
 
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

    @Transactional
    public Contact getContact(Integer id) {
    	return contactDAO.getContact(id);
    }

}

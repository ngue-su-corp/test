package com.nguesu.medisoft.service;

import java.util.List;

import com.nguesu.medisoft.form.Contact;

public interface ContactService {
	public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
    public Contact getContact(Integer id);
	public void updateContact(Contact contact);
}

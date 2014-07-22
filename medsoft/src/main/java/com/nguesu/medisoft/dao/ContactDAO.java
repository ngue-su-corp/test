package com.nguesu.medisoft.dao;

import java.util.List;

import com.nguesu.medisoft.form.Contact;

public interface ContactDAO {
	public void addContact(Contact contact);
	public void updateContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
	public Contact getContact(Integer id);
}

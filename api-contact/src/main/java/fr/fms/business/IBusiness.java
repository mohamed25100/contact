package fr.fms.business;

import fr.fms.dto.ContactDto;
import fr.fms.entities.Contact;

import java.util.List;

public interface IBusiness {
    List<Contact> getAllContacts();
    Contact addContact(ContactDto contact);
    Contact addContact(Contact contact);
    Contact updateContact(Long id, ContactDto contactDto);
    void deleteContact(Long id);

}

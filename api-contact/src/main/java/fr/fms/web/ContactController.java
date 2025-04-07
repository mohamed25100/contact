package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.dto.ContactDto;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // Autorise les requêtes CORS pour le frontend Angular
public class ContactController {

    @Autowired
    private IBusinessImpl business;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return business.getAllContacts();
    }

    // Ajout d'un contact
    @PostMapping("/contact")
    public ResponseEntity<Contact> addContact(@RequestBody ContactDto contact) {
        System.out.println(contact);
        Contact contactEntity = business.addContact(contact);
        return new ResponseEntity<>(contactEntity, HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody ContactDto contactDto) {
        Contact updatedContact = business.updateContact(id, contactDto);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        business.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
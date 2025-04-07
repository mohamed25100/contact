package fr.fms.business;

import fr.fms.dao.ContactRepository;
import fr.fms.dto.ContactDto;
import fr.fms.dto.ContactMapper;
import fr.fms.entities.Contact;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IBusinessImpl implements IBusiness{
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    ContactMapper contactMapper;


    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Transactional
    @Override
    public Contact addContact(ContactDto contact) {
        Contact newContact = contactMapper.contactDtoToContact(contact);
        Contact contactEntity = contactRepository.save(newContact);
        log.info("contactEntity créé: {}", contactEntity);
        return contactEntity;
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    @Override
    public Contact updateContact(Long id, ContactDto contactDto) {
        return contactRepository.findById(id).map(existingContact -> {
            existingContact.setFirstName(contactDto.getFirstName());
            existingContact.setLastName(contactDto.getLastName());
            existingContact.setEmail(contactDto.getEmail());
            existingContact.setPhone(contactDto.getPhone());
            existingContact.setAddress(contactDto.getAddress());
            existingContact.setCompany(contactDto.getCompany());
            existingContact.setJobTitle(contactDto.getJobTitle());
            existingContact.setBirthday(contactDto.getBirthday());

            Contact updatedContact = contactRepository.save(existingContact);
            log.info("Contact mis à jour: {}", updatedContact);
            return updatedContact;
        }).orElseThrow(() -> new RuntimeException("Contact non trouvé avec l'id : " + id));
    }

    @Transactional
    @Override
    public void deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            log.info("Contact supprimé avec succès : ID {}", id);
        } else {
            throw new RuntimeException("Contact non trouvé avec l'ID : " + id);
        }
    }

}

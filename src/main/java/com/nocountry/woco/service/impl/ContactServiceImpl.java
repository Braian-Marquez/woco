package com.nocountry.woco.service.impl;
import com.nocountry.woco.mapper.ContactMapper;
import com.nocountry.woco.model.dto.ContactDTO;
import com.nocountry.woco.model.entity.Contact;
import com.nocountry.woco.model.exception.ResourceNotFoundException;
import com.nocountry.woco.model.repository.ContactRepository;
import com.nocountry.woco.service.ContactService;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    ContactMapper contactMapper;

    @Override
    public List<ContactDTO> getAll() {

        return contactMapper.toContactsDTO(contactRepository.findAll());
    }



    @Override
    public ContactDTO getById(int id) throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact with id " + id + " not found"));
        return contactMapper.toContactDTO(contact);
    }

    @Override
    public ContactDTO post(Contact contact) {
        Contact savedContact = contactRepository.save(contact);
        return contactMapper.toContactDTO(savedContact);
    }

    @Override
    public ContactDTO patch(int id, Contact contact) throws ResourceNotFoundException {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact with id " + id + " not found"));
        if (contact.getEmail() != null) {
            existingContact.setEmail(contact.getEmail());
        }
        if (contact.getInstagram() != null) {
            existingContact.setInstagram(contact.getInstagram());
        }
        if (contact.getWebsite() != null) {
            existingContact.setWebsite(contact.getWebsite());
        }
        if (contact.getPhone() != null) {
            existingContact.setPhone(contact.getPhone());
        }
        if (contact.getWhatsapp() != null) {
            existingContact.setWhatsapp(contact.getWhatsapp());
        }

        Contact updatedContact = contactRepository.save(existingContact);
        return contactMapper.toContactDTO(updatedContact);
    }

    @Override
    public ContactDTO delete(int id) throws ResourceNotFoundException {
        Contact contactToDelete = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact with id " + id + " not found"));
        contactRepository.delete(contactToDelete);
        return contactMapper.toContactDTO(contactToDelete);
    }

}

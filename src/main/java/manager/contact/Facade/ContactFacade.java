package manager.contact.Facade;

import manager.contact.DAO.ContactDao;
import manager.contact.DTO.ContactDto;
import manager.contact.DTO.ContactTransportDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ContactFacade {

    private final ContactDao contactDao;

    public ContactFacade(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public ContactDto[] getContacts(){
        return Arrays.stream(contactDao.getContacts()).map(ContactDto::new).toArray(ContactDto[]::new);
    }

    public ContactDto getContact(long id){
        return new ContactDto(contactDao.getContact(id));
    }

    public ContactDto createContact(ContactTransportDto contact){
        return new ContactDto(contactDao.createContact(contact.getName(),contact.getSurname(),contact.getEmail(),contact.getPhone()));
    }

    public ContactDto changeContact(long id, ContactTransportDto contact){
        return new ContactDto(contactDao.changeContact(id,contact.getName(),contact.getSurname(),contact.getEmail(),contact.getPhone()));
    }

}

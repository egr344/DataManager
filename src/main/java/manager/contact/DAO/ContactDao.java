package manager.contact.DAO;

import manager.contact.Contact;

public interface ContactDao {
    Contact createContact(String name, String surname, String email, String phone);
    Contact getContact(long id);
    Contact changeContact(long id,String name,String surname,String email,String phone);
    Contact[] getContacts();
}

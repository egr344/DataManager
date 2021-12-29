package manager.contact.DAO;

import manager.contact.Contact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class ContactDaoImpl implements ContactDao {
    private Map<Long, Contact> contactTable = new HashMap<>();
    private long idContact = 0;


    public Contact createContact(String name,String surname,String email,String phone){
        if(!Pattern.matches(Contact.REGEXEMAIL,email))
            throw new IllegalArgumentException("Email incorrect");
        else if(!Pattern.matches(Contact.REGEXPHONE,phone))
            throw new IllegalArgumentException("Phone incorrect");
        contactTable.put(++idContact,new Contact(idContact,name,surname,email,phone));
        return contactTable.get(idContact);
    }

    public Contact getContact(long id){
        return contactTable.get(id);
    }

    public Contact changeContact(long id,String name,String surname,String email,String phone){
        Contact changeableContact = contactTable.get(id);
        if(name!=null)
            changeableContact.setName(name);
        if(surname!=null)
            changeableContact.setSurname(surname);
        if(email!=null){
            if(Pattern.matches(Contact.REGEXEMAIL,email))
                changeableContact.setEmail(email);
            else
                System.out.println("Email incorrect");
        }
        if(phone!=null){
            if(Pattern.matches(Contact.REGEXPHONE,phone))
                changeableContact.setPhone(phone);
            else
                System.out.println("Phone incorrect");
        }
        contactTable.put(id,changeableContact);
        return contactTable.get(id);
    }

    public Contact[] getContacts(){
        return contactTable.values().toArray(new Contact[0]);
    }


}

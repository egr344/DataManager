package manager.contact.Controller;

import manager.contact.DTO.ContactDto;
import manager.contact.DTO.ContactTransportDto;
import manager.contact.Facade.ContactFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ManagerController {

    private final ContactFacade contactFacade;

    @GetMapping
    public ContactDto[] getContacts(){
        return contactFacade.getContacts();
    }

    @PostMapping
    public ContactDto createContact(@RequestBody ContactTransportDto contact){
        return contactFacade.createContact(contact);
    }

    @GetMapping("/{id}")
    public ContactDto getContact(@PathVariable long id){
        return contactFacade.getContact(id);
    }

    @PutMapping("/{id}")
    public ContactDto changeContact(@PathVariable long id,@RequestBody ContactTransportDto contact){
        return contactFacade.changeContact(id,contact);
    }

    public ManagerController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }
}

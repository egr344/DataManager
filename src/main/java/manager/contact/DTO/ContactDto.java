package manager.contact.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import manager.contact.Contact;


public class ContactDto {

    @JsonProperty("id")
    private final long id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("surname")
    private final String surname;
    @JsonProperty("email")
    private final String email;
    @JsonProperty("phone")
    private final String phone;


    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.surname = contact.getSurname();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

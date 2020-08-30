package models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserInformation {
    private String email;
    private String password;
    private String name_on_site;
    private String name;
    private String surname;
    private boolean isActive;
    private int age;
    private int id;
    private String address;
}
